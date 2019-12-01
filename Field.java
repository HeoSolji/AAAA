public class Field extends Modifer {
    private String name_Field;
    private String type_Field;
    public Field()
    {
    }
    public Field(boolean isPublic , boolean isPrivate , boolean isProtected , boolean isStactic,String name_Field,String type_Field)
    {
        super(isPublic,isProtected,isPrivate,isStactic);
        this.name_Field=name_Field;
        this.type_Field=type_Field;
    }

    public void setName_Field(String name_Field) {
        this.name_Field = name_Field;
    }

    public void setType_Field(String type_Field) {
        this.type_Field = type_Field;
    }

    public String getName_Field() {
        return name_Field;
    }

    public String getType_Field() {
        return type_Field;
    }
    public void getField(String s)
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
        if (s.contains("static"))
        {
            isStatic=true;
            s = s.substring(s.indexOf("static")+6 , length);
            s = s.trim();
            length = s.length();
        }
        setType_Field(s.substring(0 , s.indexOf(" ")));
        setName_Field(s.substring(s.indexOf(" ")+1, s.indexOf(";")));
    }
    @Override
    public String toString() {
        String s="";
        s=s+super.toString();
        s=s+getName_Field()+":"+getType_Field();
        return s;
    }
    public static void main(String[] args)
    {
        String s="protected String a;";
        Field a = new Field();
        a.getField(s);
        System.out.println(a.toString());
    }
}

