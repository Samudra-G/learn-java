import java.util.HashMap;
import java.util.Map;

public class RNATranscription {

    private static final HashMap<Character, Character> dnaSequence = new HashMap<>(Map.of(
        'G', 'C',
        'C', 'G',
        'A', 'U',
        'T', 'A'
    ));

    public static String transcribe(String dnaStrand) {
        StringBuilder rnaStrand = new StringBuilder();
        for(char ch : dnaStrand.toUpperCase().toCharArray()) {
            if(dnaSequence.containsKey(ch)) {
                rnaStrand.append(dnaSequence.get(ch));
            } else {
                return "Faulty sequence detected. Transcription failed.";
            }
        }
        return rnaStrand.toString();
    }

    public static void main(String[] args) {
        String sequence = IO.readln("Enter a DNA sequence: ");
        String transcribedRNA = RNATranscription.transcribe(sequence.toUpperCase());

        System.out.println("Sequence: " + sequence.toUpperCase());
        System.out.println("Transcription: " + transcribedRNA);
    }
}
