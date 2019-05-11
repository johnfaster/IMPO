<div id="sc">
    <table class="table table-bordered table-responsive" style="width: 90%;margin-top:20px;" align="center">
       <caption>备件信息</caption>
        <tr>
            <td style="width: 20%;" class="td1">备件信息</td>
            <td>
                <table width="100%"class="table table-bordered table-responsive">
                    <tr>
                        <td colspan="5">
                            <div id="o_unitD" style="overflow: hidden;">
                                <!-- 是否原物项 -->
                                <div class="flex" id="sfywx" style="margin-left: 10px;">
                                    <span>是否有原物项</span>
                                    <input type="hidden" name="isOriginal" value="${isOriginal}">
                                    <label><input id="sfywx1" name="isOriginal1"   type="radio"  value="是" onchange="shifou()">是</label>
                                    <label><input id="sfywx2" name="isOriginal1" type="radio"  value="否" onchange="shifou()">否</label>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <!-- 【bigClass】大类,判断大类是否有值来控制列数的展示 【bigClass??】用于判断是否空值-->
                    <#if bigClass??  &&  bigClass != ""  >
                        <td style="width: 25%" class="td1" colspan="2"><img src="img/u374.png"></td>
                    <#else>
                        <td style="width: 25%" class="td1" ><img src="img/u374.png">i</td>
                    </#if>
                        <td style="width: 25%" class="td1">原始物项</td>
                        <td style="width: 25%; " class="ywx">原物项</td>
                        <td style="width: 25%" class="td1 twx">替代物项</td>
                    </tr>
                    <!-- 【list】用于循环展示，【mblist】后台返回的参数值，【sort_by】排序，【sortNo】序号字段 -->
                <#list mblist?sort_by("sortNo") as record>
                    <tr>
                        <!-- 【bigClass】大类,判断大类是否有值来控制列数的展示 【bigClass??】用于判断是否空值 -->
                        <#if record.bigClass??  &&  record.bigClass != ""  >
                            <!-- 【apps】用于前台js 获取表示 ，【appid】用于获取主键ID-->
                            <td style="width: 10%" class="td1  apps" appid="${record.templateId}">${record.bigClass}
                                <input id="bigClass_${record.templateId}" name="bigClass_${record.templateId}" value="${record.bigClass}" style="display: none;">
                            </td>
                            <td style="width: 15%" class="td1">${record.smallClass}
                                <input id="smallClass_${record.templateId}" name="smallClass_${record.templateId}" value="${record.smallClass}" style="display: none;">
                                <input id="templateId_${record.templateId}" name="templateId_${record.templateId}" value="${record.templateId}" style="display: none;">
                                <input id="sortNo_${record.templateId}" name="sortNo_${record.templateId}" value="${record.sortNo}" style="display: none;">
                                <input id="spareId_${record.templateId}" name="spareId_${record.templateId}" value="${record.spareId!}" style="display: none;">
                            </td>
                        <#else>
                            <td class="td1 apps" appid="${record.templateId}">${record.smallClass}
                                <input id="smallClass_${record.templateId}" name="smallClass_${record.templateId}" value="${record.smallClass}"style="display: none;" >
                                <input id="templateId_${record.templateId}" name="templateId_${record.templateId}" value="${record.templateId}" style="display: none;">
                                <input id="sortNo_${record.templateId}" name="sortNo_${record.templateId}" value="${record.sortNo}" style="display: none;">
                                <input id="spareId_${record.templateId}" name="spareId_${record.templateId}" value="${record.spareId!}" style="display: none;">
                            </td>
                        </#if>

                        <td>
                        ${record.originalItem!}
                        </td>
                        <!-- 根据是否原物项展示，默认隐藏 -->
                        <td class="ywx">
                        ${record.primitiveItems!}
                        </td>
                        <td>
                        ${record.substituteItem!}
                        </td>
                    </tr>
                </#list>
                </table>
            </td>
        </tr>
    </table>
</div>