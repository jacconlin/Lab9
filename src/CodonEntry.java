import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class reads in data from several files, building an arraylist
 * of "codon"s with the./
 */

public class CodonEntry {
    public ArrayList<Codon> codons;

    public CodonEntry(String file_nam) throws IOException {
        File f = new File(file_nam);
        Scanner infile = new Scanner(f);

        //we're guessing that there's less than 800 codons in total
        this.codons = new ArrayList<>(800);

        String fullSeq = "";

        //we skip the first line of the .fasta file
        infile.nextLine();
        while (infile.hasNextLine()) {
            String line = infile.nextLine().trim();
            fullSeq += line;
        }
        infile.close();

        String[] codonLine = getStrings(fullSeq);
        for (String c : codonLine) {
            codons.add(new Codon(c));
        }
    }

    /**
     * @param line an unfiltered line full of codons
     * @return an array of codons, taken from the concatenated string
     * @author Jackson Lindstrom
     */

    private static String[] getStrings(String line) {
        String output = "";

        //we add a "-" every three characters in each line
        //looks like this: ATG-GAG-AGC-CTT-GTC-CCT-GGT...
        for (int i = 0; i < line.length(); i += 3) {
            String codon = line.substring(i, Math.min(i + 3, line.length()));
            output += "-";
            output += codon;
        }
        output = output.substring(1);

        //we make an array of strings, splitting it with each "-"
        //looks like this: [ATG, GAG, AGC, CTT, GTC, CCT, GGT, ...]
        return output.split("-");
    }
}
