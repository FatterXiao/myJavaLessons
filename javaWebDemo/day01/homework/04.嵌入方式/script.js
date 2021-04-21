window.onload = function () {
    //获取按钮对象
    var btnEle = document.getElementById("btnId");
// alert(btnEle);
    //给按钮对象绑定单击事件
    btnEle.onclick = function(){
        //弹出提示框
        alert("Hello JS");
    };
};
