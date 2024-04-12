package spring.type_convert.property_editor;

import java.beans.PropertyEditorSupport;

public class String2UserPropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User user = new User(text);
        this.setValue(user);
    }
}
