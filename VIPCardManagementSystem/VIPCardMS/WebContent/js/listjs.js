/**
 * Created by guowh on 2016/12/25.
 */

/*
 *打开或关闭菜单
 * @param thisz 触发事件对象
 */
function openOrCloseMenu(thisz) {
    //父节点菜单ID
    var parentID = thisz.id;
    //获得所有子节点
    var subNodes = document.getElementsByName(parentID);
    //判断显示属性
    //1、判断是否存在子节点,不存在返回
    if (subNodes.length < 1) {
        return;
    }
    //2、存在，隐藏就显示，显示就隐藏
    if (subNodes[0].style.display == "none") {
        for (i = 0; i < subNodes.length; i++)
            subNodes[i].style.display = "block";//隐藏
    }
    else {
        for (i = 0; i < subNodes.length; i++)
            subNodes[i].style.display = "none";//显示
    }
//            alert("状态："+subNodes[0].style.display)
}
