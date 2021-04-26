package tool;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/*
 * 对象工具
 */
public class ObjectTool {

    public static String getObjectValue(Object object, String key) throws Exception {
        // 我们项目的所有实体类都继承BaseDomain （所有实体基类：该类只是串行化一下）
        // 不需要的自己去掉即可
        if (object != null) {// if (object!=null ) ----begin
            // 拿到该类
            Class<?> clz = object.getClass();
            // 获取实体类的所有属性，返回Field数组
            Field[] fields = clz.getDeclaredFields();

            for (Field field : fields) {// --for() begin
                //System.out.println("属性类型："+field.getGenericType());// 打印该类的所有属性类型
                //System.out.println(field.getName());
                if (key.equals(field.getName())) {
                    return field.getGenericType().toString();
                }
            }
        }
        return null;
    }

    /*
     * java 反射获取对象的属性和值
     */
    public static List<Object> getValues(Object object) {
        List<Object> values = new ArrayList<Object>();
        Class<? extends Object> clazz = object.getClass();
        // 获取类中声明的字段
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 避免 can not access a member of class com.java.test.Person with modifiers
            // "private"
            field.setAccessible(true);
            try {
                Object valObject = field.get(object);
                if (valObject != null && !field.getName().equals("id"))
                    values.add(valObject);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return values;
    }

    // 获取对象的所有属性
    public static List<String> getKevs(Object object) {
        List<String> values = new ArrayList<String>();
        Class<? extends Object> clazz = object.getClass();
        // 获取类中声明的字段
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 避免 can not access a member of class com.java.test.Person with modifiers
            // "private"
            field.setAccessible(true);
            values.add(field.getName());
        }
        return values;
    }

    /**
     * java反射bean的set方法
     *
     * @param objectClass
     * @param fieldName
     * @return
     */
    public static Method getSetMethod(Class<? extends Object> objectClass, String fieldName) {
        try {
            @SuppressWarnings("rawtypes")
            Class[] parameterTypes = new Class[1];
            Field field = objectClass.getDeclaredField(fieldName);
            parameterTypes[0] = field.getType();
            StringBuffer sb = new StringBuffer();
            sb.append("set");
            sb.append(fieldName.substring(0, 1).toUpperCase());
            sb.append(fieldName.substring(1));
            Method method = objectClass.getMethod(sb.toString(), parameterTypes);
            return method;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 执行set方法
     *
     * @param o         执行对象
     * @param fieldName 属性
     * @param value     值
     */
    public static void invokeSet(Object o, String fieldName, Object value) {
        try {
            value = getValueType(getObjectValue(o, fieldName), value);
            Method method = getSetMethod(o.getClass(), fieldName);
            method.invoke(o, new Object[]{value});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getValueType(String typeString, Object value) throws Exception {
        if (typeString.equals("boolean")) {
            return (Boolean) value;
        }
        if (typeString.equals("class java.lang.String")) {
            return (String) value;
        }
        if (typeString.equals("int") || typeString.equals("class java.lang.Integer")) {
            if (value != null && !value.equals("")) {
                return Integer.parseInt((String) value);
            } else {
                return 0;
            }
        }
        if (typeString.equals("double")) {
            return Double.valueOf((String) value);
        }
        if (typeString.equals("class java.util.Date")) {
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dutyDay = (java.util.Date) simpleDateFormat.parse((String) value);
            return dutyDay;
        }
        throw new Exception("错误数据类型" + typeString);
    }
}
