package com.tree.mvpdemo.model;

/*
 *  @项目名：  MVPDemo 
 *  @包名：    com.tree.mvpdemo.model
 *  @文件名:   DataModel
 *  @创建者:   Administrator
 *  @创建时间:  2018/3/23 17:21
 *  @描述：    TODO
 */

public class DataModelManager {

    /**
     * className 存的是对应类名
     * @param className
     * @return
     */
    public static BaseModel request(String className) {
        BaseModel model = null;
        try {
            //利用反射机制获得对应model对象的引用
            model = (BaseModel) Class.forName(className)
                                     .newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
}
