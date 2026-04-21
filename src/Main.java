import java.util.Arrays;

    public static void main() throws IOException {
        CodonEntry replicase = new CodonEntry("replicase.fasta");
        CodonEntry spike = new CodonEntry("spike.fasta");

        System.out.println("the replicase codons: " + replicase.codons);
        System.out.println("the spike codons: " + spike.codons);
    }


/**Bryan