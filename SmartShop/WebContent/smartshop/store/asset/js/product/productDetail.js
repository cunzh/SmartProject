

//var requestCommentMsg = {
//    url: URL_COMMENT,
//    callbackMethod: setOwnerData,
//    data: ""
//};
//var requestProductMsg = {
//    url: URL_PRODUCT,
//    callbackMethod: setOwnerData,
//    data: ""
//};

//已录入楼宇对象
var commentMsg = {
    name: "",
    rank: "",
    content: "",
    time: "",
};

$(document).ready(function () {

   // getCommentData();//初始化表格数据
    setCommentData();
    setShopType();
    setProduct();
   
});

function setShopType() {
    document.getElementById("shop").innerHTML = "小漠阳阳";

    document.getElementById("shoptype").innerHTML = "<li><a href='#.html' data-hover='Company Profile'>所有分类</a></li><li><a href='#.html' data-hover='Company Profile'>衣服</a></li>"
   
}
 
function setProduct() {
}



//function setCommentData(data) {
function setCommentData() {
    //var dataArray = new Array(); //数据对象数组
    //for (var i = 0; i < data.result.length; i++) {
    //    commentMsg = new Object();

    //    commentMsg.name = data.result[i].name;
    //    commentMsg.rank = data.result[i].rank;
    //    commentMsg.content = data.result[i].content;
    //    commentMsg.time = data.result[i].time;
    //    dataArray.push(commentMsg);
    //}
    var dataArray = new Array(); //数据对象数组
    for (var i = 0; i < 16; i++) {
        commentMsg = new Object();

        commentMsg.name = "老王";
        commentMsg.rank = "好评";
        commentMsg.content = "看起来很好";
        commentMsg.time = ""+i;
        dataArray.push(commentMsg);
    }

    var sequenceArray = new Array();//序列数组
    sequenceArray[0] = "name";
    sequenceArray[1] = "rank";
    sequenceArray[2] = "content";
    sequenceArray[3] = "time";

    //totalPage = data.totalPage;
    totalPage = 2;
    $("#comment_tableBody tr").not("tr:first").remove(); //清空除第一行之外的表内容
    addTableBody("comment", dataArray, sequenceArray); //调用公用添加table方法

    $("#comment").dataTable({
        "aLengthMenu": [[8, 16, 32, 64], [8, 16, 32, 64]],
        "bFilter": false,
        "bRetrieve": true,
        "bSort": true,
        "bInfo": false,
        "bJQueryUI": false,
        "iDisplayLength": 8,
        "bPaginate": true,       //翻页功能
        "bLengthChange":false,       //改变每页显示数据数量
        "aaSorting": [[1, "desc"]],//设置第2个元素为默认排序     
        "aoColumnDefs": [{
            "bSortable": false, //指定不支持排序的列  
            "aTargets": [0]
        }],
        "oLanguage": {
            "sZeroRecords": "对不起，查询不到任何相关数据",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
            "sInfoEmpty": "记录数为0",
            "sSearch": "搜索:",
            "sInfoFiltered": "  ，共搜索 _MAX_ 条记录",
            "sLengthMenu": "每页显示 _MENU_ 条记录",
            "oPaginate": {
                "sNext": "下一页",
                "sPrevious": "上一页"
            }
        }
    });


}