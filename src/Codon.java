/**
 * This class represents a single codon, and its data
 * @author Jackson Lindstrom
 */

public class Codon
{
    private final String sequence;
    private final String amino_name;
    private final String aa_abbrev;

    public Codon(String sequence, String amino_Name, String aa_abbrev) {
        this.sequence = sequence;
        this.amino_name = amino_Name;
        this.aa_abbrev = aa_abbrev;
    }

    public String getSequence()
    {
        return this.sequence;
    }

    public String getAmino_name()
    {
        return this.amino_name;
    }

    public String getAa_abbrev()
    {
        return this.aa_abbrev;
    }
}
