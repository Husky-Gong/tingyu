function   getGson(o) {

    //[A]获得所有的查询的数据
    var  val=o.serializeArray();
    //手动获得json格式
    var obj ={};
    for(var i =0;i<val.length;i++){
        obj[val[i].name]=val[i].value;
    }
    return  obj;

}