package com.example.demo.service;

import com.example.demo.domain.ExampleExcelEmp;
import com.example.demo.domain.User;
import com.example.demo.mapper.ExampleExcelEmpMapper;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.title;

@Service
@Transactional
public class EmpService implements  IEmpService{

    private ConcurrentMap<Integer,User> repository = new ConcurrentHashMap<>();
    @Autowired
    private final static AtomicInteger idGenerator = new AtomicInteger();
    @Autowired

private ExampleExcelEmpMapper exampleExcelEmpMapper;
    public void insert(Long id,String name){
        ExampleExcelEmp emp = new ExampleExcelEmp();
        //Integer id = idGenerator.incrementAndGet();
        emp.setEmpname(name);
        emp.setEmpid(id);
        Integer orgid = 2;
        emp.setOrgid(orgid.longValue());
        emp.setEmpcode("008");
        exampleExcelEmpMapper.insert(emp);
        System.out.printf("用户对象：%s保存成功！\n",emp);
    }
    public void importEmp(HttpServletResponse response){
        List<ExampleExcelEmp> list =  exampleExcelEmpMapper.queryEmpList();
        export(list,response);
    }
    // 显示的导出表的标题
    private String title;
    // 导出表的列名
    private String[] rowName;
    // 表的内容
    private List<Object[]> dataList = new ArrayList<Object[]>();


    public static void export(List<ExampleExcelEmp> list,HttpServletResponse response){

        HttpServletResponse respone = null;
        OutputStream out = null;
        HSSFWorkbook workbook = new HSSFWorkbook(); // 创建工作簿对象
        HSSFSheet sheet = workbook.createSheet("员工信息"); // 创建工作表
        HSSFRow row = null;
        HSSFCell cell = null;
        for(int i=0;i<list.size();i++){
            // 设置单元格的数据类型
            ExampleExcelEmp emp = new ExampleExcelEmp();
            emp =list.get(i);
            // 创建所需的行数
            row = sheet.createRow(i + 1);
           /* row.createCell((short)0);
            Long empid = emp.getEmpid();
            cell.setCellValue(empid);*/
            cell = row.createCell((short)1);
            cell.setCellValue(emp.getEmpname());
            cell= row.createCell((short)2);
            cell.setCellValue(emp.getBirthday());
            cell= row.createCell((short)3);
            cell.setCellValue(emp.getEmpcode());
            cell = row.createCell((short)4);
            cell.setCellValue(emp.getAddress());
            cell= row.createCell((short)5);
            cell.setCellValue(emp.getPhone());
        }
        // 取当前时间的4-13位作名字
        String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
        String headStr = "attachment; filename=\"" + fileName + "\"";
        respone = response;
        respone.reset();
        respone.setHeader("Content-disposition", "attachment; filename=details.xls");
        respone.setContentType("application/msexcel");
        try {
            out = new BufferedOutputStream(respone.getOutputStream());
            workbook.write(out);
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("导出完成");
    }
    public static void outFile(HSSFWorkbook workbook,String path) {
        OutputStream os=null;
        try {
            os = new FileOutputStream(new File(path));
            workbook.write(os);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
