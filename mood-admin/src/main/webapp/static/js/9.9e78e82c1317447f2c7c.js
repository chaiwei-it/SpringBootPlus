webpackJsonp([9],{"+e60":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=a("EFWR"),n=o.a.ajax,s=o.a.api,i=o.a.dateFormat,r={data:function(){return{tableData:[],addView:!1,updateView:!1,pager:{specId:this.$route.params.id,name:"",pageIndex:1,pageSize:10,orderBy:"sort_num asc"},form:{id:"",name:"",specId:this.$route.params.id,showStatus:"",image:"",sortNum:""},total:0}},mounted:function(){null==this.pager.specId||""===this.pager.specId?window.history.go(-1):this.getPager()},methods:{toData:function(e,t){return i(e,t)},handleSizeChange:function(e){this.pager.pageSize=e,this.getPager()},handleCurrentChange:function(e){this.pager.pageIndex=e,this.getPager()},getPager:function(){var e=this;n(s.specValuePager,"POST",this.pager,function(t){e.tableData=t.list,e.total=t.total,e.pager.pageIndex=t.pageIndex,t.pageIndex>t.maxPages&&(e.pager.pageIndex=t.maxPages,e.getPager())})},handleDelete:function(e){var t=this;this.$confirm("确认删除该规格值吗?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){n(s.specValueDelete,"DELETE",{id:e},function(e){t.$message({type:"success",message:"删除成功!"}),t.getPager()})}).catch(function(){t.$message({type:"info",message:"已取消删除"})})},toUpdateView:function(e){this.vacant(),this.getDetails(e),this.updateView=!0},toAddView:function(){this.vacant(),this.addView=!0},add:function(e){var t=this;this.$refs[e].validate(function(e){if(!e)return console.log("error submit!!"),!1;n(s.specValueAdd,"POST",t.form,function(e){t.addView=!1,t.getPager(),t.$message({message:"添加成功",type:"success"})})})},update:function(e){var t=this;this.$refs[e].validate(function(e){if(!e)return console.log("error submit!!"),!1;n(s.specValueUpdate,"PUT",t.form,function(e){t.updateView=!1,t.getPager(),t.$message({message:"修改成功",type:"success"})})})},getDetails:function(e){var t=this;n(s.specValueSelect,"POST",{id:e},function(e){t.form.id=e.id,t.form.name=e.name,t.form.showStatus=e.showStatus,t.form.specId=e.specId,t.form.sortNum=e.sortNum,t.form.image=e.image})},vacant:function(){this.form.id="",this.form.name="",this.form.specId=this.$route.params.id,this.form.showStatus="",this.form.sortNum="",this.form.image=""},cancal:function(){window.history.go(-1)}}},l={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"specValue"},[a("el-row",{staticClass:"spec-button"},[a("el-button",{attrs:{type:"primary"},on:{click:e.toAddView}},[e._v("添加")]),e._v(" "),a("el-button",{on:{click:e.cancal}},[e._v("返回")]),e._v(" "),a("el-input",{staticClass:"name",attrs:{placeholder:"名称"},model:{value:e.pager.name,callback:function(t){e.$set(e.pager,"name",t)},expression:"pager.name"}}),e._v(" "),a("el-button",{on:{click:e.getPager}},[e._v("查询")])],1),e._v(" "),a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData,border:""}},[a("el-table-column",{attrs:{type:"index",width:"50"}}),e._v(" "),a("el-table-column",{attrs:{prop:"name",label:"名称",width:"120",sortable:""}}),e._v(" "),a("el-table-column",{attrs:{prop:"showStatus",label:"是否展示",width:"120",sortable:""},scopedSlots:e._u([{key:"default",fn:function(t){return[0==t.row.showStatus?a("el-tag",{attrs:{size:"small",type:"info"}},[e._v("已停用")]):e._e(),e._v(" "),1==t.row.showStatus?a("el-tag",{attrs:{size:"small",type:""}},[e._v("已启用")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"sortNum",label:"排序",width:"100",sortable:""}}),e._v(" "),a("el-table-column",{attrs:{prop:"createTime",label:"创建时间",formatter:e.toData,width:"165"}}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini"},on:{click:function(a){e.toUpdateView(t.row.id)}}},[e._v("编辑")]),e._v(" "),a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){e.handleDelete(t.row.id)}}},[e._v("删除")])]}}])})],1),e._v(" "),a("el-pagination",{attrs:{background:"","current-page":e.pager.pageIndex,"page-sizes":[5,10,20,40],"page-size":e.pager.pageSize,layout:"total, sizes, prev, pager, next, jumper",total:e.total},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.pager,"pageIndex",t)}}}),e._v(" "),a("el-dialog",{attrs:{title:"添加",visible:e.addView,width:"500px"},on:{"update:visible":function(t){e.addView=t}}},[a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"80px",size:"small"}},[a("el-form-item",{attrs:{label:"名称"}},[a("el-input",{model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"是否展示"}},[a("el-switch",{attrs:{"active-value":1,"inactive-value":0},model:{value:e.form.showStatus,callback:function(t){e.$set(e.form,"showStatus",t)},expression:"form.showStatus"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"排序编号"}},[a("el-input",{model:{value:e.form.sortNum,callback:function(t){e.$set(e.form,"sortNum",t)},expression:"form.sortNum"}})],1),e._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.add("form")}}},[e._v("添加")]),e._v(" "),a("el-button",{on:{click:function(t){e.addView=!1}}},[e._v("取消")])],1)],1)],1),e._v(" "),a("el-dialog",{attrs:{title:"修改",visible:e.updateView,width:"500px"},on:{"update:visible":function(t){e.updateView=t}}},[a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"80px",size:"small"}},[a("el-form-item",{attrs:{label:"名称"}},[a("el-input",{model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"是否展示"}},[a("el-switch",{attrs:{"active-value":1,"inactive-value":0},model:{value:e.form.showStatus,callback:function(t){e.$set(e.form,"showStatus",t)},expression:"form.showStatus"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"排序编号"}},[a("el-input",{model:{value:e.form.sortNum,callback:function(t){e.$set(e.form,"sortNum",t)},expression:"form.sortNum"}})],1),e._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.update("form")}}},[e._v("修改")]),e._v(" "),a("el-button",{on:{click:function(t){e.updateView=!1}}},[e._v("取消")])],1)],1)],1)],1)},staticRenderFns:[]};var u=a("vSla")(r,l,!1,function(e){a("2Aq9")},null,null);t.default=u.exports},"2Aq9":function(e,t,a){var o=a("CPKm");"string"==typeof o&&(o=[[e.i,o,""]]),o.locals&&(e.exports=o.locals);a("8bSs")("10c1fe35",o,!0)},CPKm:function(e,t,a){(e.exports=a("BkJT")(!1)).push([e.i,"\n.spec-button{\r\n  height: 60px;\r\n  padding: 10px;\n}\n.name{\r\n  width: 200px;\r\n  margin-left: 50px;\n}\r\n",""])}});