package pl.net.bluesoft.rnd.processtool.ui.basewidgets.editor;

import pl.net.bluesoft.rnd.processtool.ui.basewidgets.xml.validation.XmlValidationError;
import pl.net.bluesoft.rnd.util.i18n.I18NSource;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Utility functions, used across entire package
 *
 * @author tlipski@bluesoft.net.pl
 */
class EditorHelper {
    public static Annotation getAnnotation(Class cls, Class<? extends Annotation> annotationCls) {
        Annotation res = cls.getAnnotation(annotationCls);
        if (res != null) {
            return res;
        } else if (!cls.equals(Object.class)) {
            return getAnnotation(cls.getSuperclass(), annotationCls);
        } else {
            return null;
        }
    }

    public static Annotation getFieldAnnotation(Class cls, Class<? extends Annotation> annotationCls) {
        for (Field f : cls.getDeclaredFields()) {
            Annotation annotation = f.getAnnotation(annotationCls);
            if (annotation != null) return annotation;
        }
        if (!cls.equals(Object.class)) {
            return getFieldAnnotation(cls.getSuperclass(), annotationCls);
        } else {
            return null;
        }
    }

    public static Field getFieldWithAnnotation(Class cls, Class<? extends Annotation> annotationCls) {
        for (Field f : cls.getDeclaredFields()) {
            Annotation annotation = f.getAnnotation(annotationCls);
            if (annotation != null) return f;
        }
        if (!cls.equals(Object.class)) {
            return getFieldWithAnnotation(cls.getSuperclass(), annotationCls);
        } else {
            return null;
        }
    }

    public static Field findField(Object propertyId, Class classOfItem) {
        Field declaredField;
        try {
            declaredField = classOfItem.getDeclaredField(String.valueOf(propertyId));
        } catch (NoSuchFieldException e) {
            declaredField = null;
        }
        if (declaredField == null && !Object.class.equals(classOfItem))
            return findField(propertyId, classOfItem.getSuperclass());
        return declaredField;
    }

    public static String joinValidationErrors(List<XmlValidationError> xmlValidationErrors) {
        String msg = "";
        for (XmlValidationError err : xmlValidationErrors) {
            msg += getLocalizedMessage(err.getMessageKey()).replace("%s", getLocalizedMessage(err.getField())) + " \n";
        }
        return msg;
    }
    
    public static String getLocalizedMessage(String key) {
        return I18NSource.ThreadUtil.getLocalizedMessage(
                (key.startsWith("processdata") ? "" : "widget.process_data_block.editor.") + key);
    }
    
}
