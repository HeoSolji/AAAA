
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Classs extends Modifer{
    private String name;
    private String name_Class_extend ;
    private String name_Class_Implement;
    private boolean isAbstraction;
    private boolean isExtend;
    private boolean isImplement;
    private List<Method> methods= new ArrayList<Method>();
    private List<Field> fields =new ArrayList<Field>();
    private List <String> stringFields= new ArrayList<String>();
    private List <String> stringMethods= new ArrayList<String>();
    private List <String> stringConstructors= new ArrayList<String>();
    private List<Constructors> constructors = new ArrayList<Constructors>();
    public Classs()
    {
    }
    public Classs(String name ,boolean isPublic, boolean isPrivate , boolean isProtected , boolean isStatic,  boolean isAbstraction , boolean isExtend , boolean isImplement , List<Method> methods , List<Field> fields ,List<Constructors> constructors )
    {
        super(isPublic , isProtected , isPrivate , isStatic);
        this.name= name;
        this.isAbstraction= isAbstraction;
        this.isExtend= isExtend;
        this.isImplement=isImplement;
        this.methods= methods;
        this.fields=fields;
        this.constructors=constructors;
    }
    
    public List<String> getStringFields()
    {
        List<String> list = new ArrayList<>();
        for (Field f :fields)
        {
            list.add(f.toString());
        }
        return  list;
    }
    
    public List<String> getStringMethods()
    {
        List<String> list = new ArrayList<>();
        for (Method f :methods)
        {
            list.add(f.toString());
        }
        return  list;
    }
    
    public List<String> getStringConstructors(){
    	return stringConstructors;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAbstraction(boolean abstraction) {
        isAbstraction = abstraction;
    }

    public void setExtend(boolean extend) {
        isExtend = extend;
    }

    public void setImplement(boolean implement) {
        isImplement = implement;
    }

    public void setConstructors(List<Constructors> constructors) {
        this.constructors = constructors;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
    public String getName() {
        return name;
    }

    public void setName_Class_extend(String name_Class_extend) {
        this.name_Class_extend = name_Class_extend;
    }

    public void setName_Class_Implement(String name_Class_Implement) {
        this.name_Class_Implement = name_Class_Implement;
    }

    public String getName_Class_Implement() {
        return name_Class_Implement;
    }

    public List<Constructors> getConstructors() {
        return constructors;
    }

    public List<Field> getFields() {
        return fields;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public String getName_Class_extend() {
        return name_Class_extend;
    }

    public void getNameClasss(String s)
    {
        int length =s.length();
        if  (s.contains("public") )
        {
            isPublic=true;
            s = s.substring(s.indexOf("public") + 7 , length);
            length = s.length();
        }
        if (s.contains("private"))
        {
            isPrivate=true;
            s = s.substring(s.indexOf("private") +7 , length);
            s= s.trim();
            length = s.length();
        }
        if (s.contains("protected"))
        {
            isProtected=true;
            s = s.substring(s.indexOf("protected")+9 , length);
            s=s.trim();
            length = s.length();
        }
        if (s.contains("abstract"))
        {
            isAbstraction=true;
            s = s.substring(s.indexOf("abstract")+8 , length);
            s = s.trim();
            length = s.length();

        }
        if (s.contains("extends"))
        {
            isExtend=true;
            String s_extends = s.substring(s.indexOf("extends")+7 , length);
            s = s.substring(0 , s.indexOf("extends"));
            s_extends = s_extends.trim();
            setName_Class_extend(s_extends.substring(0, s_extends.indexOf("{")));
        }
        name = s.substring(s.indexOf(" ")+1 , s.length());

    }
    public void getClasss(List<String> lines)
    {
        int i =0;
        String name_class;
        while (!lines.get(i).contains("class"))
            i++;
        getNameClasss(lines.get(i));
        for (int index = i ;index<lines.size()-1;index++)
        {
            if(lines.get(index).contains(";") && !lines.get(index).contains("{") && !lines.get(index).contains("abstract"))
            {
                //System.out.println(lines.get(index));
                Field newfield = new Field();
                newfield.getField(lines.get(index));
                fields.add(newfield);
            }
            else if ((lines.get(index).contains("(")) && !lines.get(index).contains("="))
            {
                Method new_method = new Method();
                new_method.getMethod(lines.get(index));
                methods.add(new_method);
            }
        }
    }
    public String toString(){
        String result="";
        result = result + "Class extends : " +  getName_Class_extend();
        result = result+getName() +'\n';
        for (Field field :fields)
            result = result+ field.toString()+'\n';
        for (Method method :methods) {
            result = result + method.toString() + '\n';
        }
        return result;
    }
    public void show()
    {
        for (Method method : methods)
        {
            System.out.println(method.toString());
        }
    }

}
