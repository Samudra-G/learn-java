import java.util.ArrayList;
import java.util.List;

class LanguageList {
    private List<String> languages;

    public LanguageList() {
        this.languages = new ArrayList<>();
    }

    public boolean isEmpty() {
        return languages.isEmpty();
    }

    public void addLanguage(String language) {
        languages.add(language);
    }

    public void removeLanguage(String language) {
        if (languages.contains(language)) {
            IO.println("Removing language: " + language);
            languages.remove(language);
        } else {
            IO.println("Specified language not in list.");
            return;
        }
    }

    public String firstLanguage() {
        return languages.getFirst();
    }

    public int count() {
        return languages.size();
    }

    public boolean containsLanguage(String language) {
        return languages.contains(language);
    }

    public boolean isExciting() {
        return languages.contains("Java") || languages.contains("Kotlin");
    }

    public static void main(String[] args) {
        LanguageList list = new LanguageList();

        // Check if empty
        System.out.println("Is empty? " + list.isEmpty());

        // Add languages
        list.addLanguage("Java");
        list.addLanguage("Python");
        list.addLanguage("Go");

        // Count
        System.out.println("Language count: " + list.count());

        // First language
        System.out.println("First language: " + list.firstLanguage());

        // Check existence
        System.out.println("Contains Go? " + list.containsLanguage("Go"));
        System.out.println("Contains C++? " + list.containsLanguage("C++"));

        // Exciting?
        System.out.println("Is exciting? " + list.isExciting());

        // Remove language
        list.removeLanguage("Python");
        list.removeLanguage("C++");

        // Final count
        System.out.println("Final count: " + list.count());

        // Final empty check
        System.out.println("Is empty? " + list.isEmpty());
    }
}
