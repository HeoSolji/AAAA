import java.util.*;
public class ClassObj {
	public String ClassName;
	public List <String> stringFields;
	public List <String> stringMethods;
	public List <Field> listFields;
	public List <Method> listMethods;
	public ClassObj(String _ClassName, List<String> _fields,List<String> _methods) {
		ClassName= _ClassName;
		stringFields =_fields;
		stringMethods= _methods;
	}
//	public String to_String() {
//		return ClassName;
//	}
//	public void setStringforClassObj() {
//		for(Field f: listFields) {
//			stringFields.add(f.toString());
//		}
//		for(Method m: listMethods) {
//			stringMethods.add(m.toString());
//		}
//	}
}
