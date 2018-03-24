public class Project{
    private String name;
    private String description;
    public void setName(String name){
        this.name = name;
    }
    public void setDesc(String descritption){
        this.description = descritption;
    }
    public String elavatorPitch(){
        return(this.name+","+this.description);
    }
}