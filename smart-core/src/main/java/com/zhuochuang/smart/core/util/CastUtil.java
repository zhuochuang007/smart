package com.zhuochuang.smart.core.util;

/** 
 * 转型工具类
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年4月10日] 
 */
public class CastUtil
{
    /** 
     * 转为String类型
     * <功能详细描述>
     * @param obj
     * @return 
     */
    public static String castString(Object obj)
    {
        return CastUtil.castString(obj, "");
    }
    
    /** 
     * 转为String类型(提供默认值) 
     * <功能详细描述>
     * @param obj
     * @param defaultValue
     * @return 
     */
    public static String castString(Object obj, String defaultValue)
    {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }
    
    /** 
     * 转为double型
     * <功能详细描述>
     * @param obj
     * @return 
     */
    public static double castDouble(Object obj)
    {
        return CastUtil.castDouble(obj, 0);
    }
    
    /** 
     * 转为double型(提供默认值) 
     * <功能详细描述>
     * @param obj
     * @param defaultValue
     * @return 
     */
    public static double castDouble(Object obj, double defaultValue)
    {
        double doubleValue = defaultValue;
        if (obj != null)
        {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue))
            {
                try
                {
                    doubleValue = Double.parseDouble(strValue);
                }
                catch (NumberFormatException e)
                {
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }
    
    /** 
     * 转为long型
     * <功能详细描述>
     * @param obj
     * @return 
     */
    public static long castLong(Object obj)
    {
        return CastUtil.castLong(obj, 0);
    }
    
    /** 
     * 转为double型(提供默认值) 
     * <功能详细描述>
     * @param obj
     * @param defaultValue
     * @return 
     */
    public static long castLong(Object obj, long defaultValue)
    {
        long longValue = defaultValue;
        if (obj != null)
        {
            String strValue = CastUtil.castString(obj);
            if (StringUtil.isNotEmpty(strValue))
            {
                try
                {
                    longValue = Long.parseLong(strValue);
                }
                catch (NumberFormatException e)
                {
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }
    
    /** 
     * 转为int型 
     * <功能详细描述>
     * @param obj
     * @return 
     */
    public static int castInt(Object obj)
    {
        return CastUtil.castInt(obj, 0);
    }
    
    /** 
     * 转为int型(提供默认值) 
     * <功能详细描述>
     * @param obj
     * @param defaultValue
     * @return 
     */
    public static int castInt(Object obj, int defaultValue)
    {
        int intValue = defaultValue;
        if (obj != null)
        {
            String strValue = CastUtil.castString(obj);
            if (StringUtil.isNotEmpty(strValue))
            {
                try
                {
                    intValue = Integer.parseInt(strValue);
                }
                catch (NumberFormatException e)
                {
                    intValue = defaultValue;
                }
            }
        }
        return intValue;
    }
    
    /** 
     * 转为boolean型 
     * <功能详细描述>
     * @param obj
     * @return 
     */
    public static boolean castBoolean(Object obj)
    {
        return CastUtil.castBoolean(obj, false);
    }
    
    /** 
     * 转为boolean型(提供默认值) 
     * <功能详细描述>
     * @param obj
     * @param defaultValue
     * @return 
     */
    public static boolean castBoolean(Object obj, boolean defaultValue)
    {
        boolean booleanValue = defaultValue;
        if (obj != null)
        {
            booleanValue = Boolean.parseBoolean(CastUtil.castString(obj));
        }
        return booleanValue;
    }
    
    /** 
     * 转为String[]型 
     * <功能详细描述>
     * @param obj
     * @return 
     */
    public static String[] castStringArray(Object[] objArray)
    {
        if (objArray == null)
        {
            objArray = new Object[0];
        }
        String[] strArray = new String[objArray.length];
        if (ArrayUtil.isNotEmpty(objArray))
        {
            for (int i = 0, arrayLength = objArray.length; i < arrayLength; i++)
            {
                strArray[i] = CastUtil.castString(objArray[i]);
            }
        }
        return strArray;
    }
    
    /** 
     * 转为double[]型 
     * <功能详细描述>
     * @param obj
     * @return 
     */
    public static double[] castDoubleArray(Object[] objArray)
    {
        if (objArray == null)
        {
            objArray = new Object[0];
        }
        double[] doubleArray = new double[objArray.length];
        if (ArrayUtil.isNotEmpty(objArray))
        {
            for (int i = 0, arrayLength = objArray.length; i < arrayLength; i++)
            {
                doubleArray[i] = CastUtil.castDouble(objArray[i]);
            }
        }
        return doubleArray;
    }
    
    /** 
     * 转为long[]型 
     * <功能详细描述>
     * @param obj
     * @return 
     */
    public static long[] castLongArray(Object[] objArray)
    {
        if (objArray == null)
        {
            objArray = new Object[0];
        }
        long[] longArray = new long[objArray.length];
        if (ArrayUtil.isNotEmpty(objArray))
        {
            for (int i = 0, arrayLength = objArray.length; i < arrayLength; i++)
            {
                longArray[i] = CastUtil.castLong(objArray[i]);
            }
        }
        return longArray;
    }
    
    /** 
     * 转为int[]型 
     * <功能详细描述>
     * @param obj
     * @return 
     */
    public static int[] castIntArray(Object[] objArray)
    {
        if (objArray == null)
        {
            objArray = new Object[0];
        }
        int[] intArray = new int[objArray.length];
        if (ArrayUtil.isNotEmpty(objArray))
        {
            for (int i = 0, arrayLength = objArray.length; i < arrayLength; i++)
            {
                intArray[i] = CastUtil.castInt(objArray[i]);
            }
        }
        return intArray;
    }
    
    /** 
     * 转为boolean[]型 
     * <功能详细描述>
     * @param obj
     * @return 
     */
    public static boolean[] castBooleanArray(Object[] objArray)
    {
        if (objArray == null)
        {
            objArray = new Object[0];
        }
        boolean[] booleanArray = new boolean[objArray.length];
        if (ArrayUtil.isNotEmpty(objArray))
        {
            for (int i = 0, arrayLength = objArray.length; i < arrayLength; i++)
            {
                booleanArray[i] = CastUtil.castBoolean(objArray[i]);
            }
        }
        return booleanArray;
    }
}
