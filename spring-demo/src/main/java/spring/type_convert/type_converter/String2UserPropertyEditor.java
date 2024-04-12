package spring.type_convert.type_converter;


import java.beans.PropertyEditorSupport;

public class String2UserPropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User user = new User(text);
        this.setValue(user);
    }
}
