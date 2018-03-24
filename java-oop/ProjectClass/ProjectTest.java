public class ProjectTest{
    public static void main(String[] args) {
        Project proj = new Project();
        proj.setName("Olefactory Friend");
        proj.setDesc(" Find a freind who doesn't stink!");
        String pitch = proj.elavatorPitch();
        System.out.println(pitch);
    }
}