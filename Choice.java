public class Choice {
    String description;
    Scene nextScene;

    public Choice(String newDescription) {
        description = newDescription;
    }
    
    public Choice(String newDescription, Scene newScene) {
        this(newDescription);
        nextScene = newScene;
    }
}
