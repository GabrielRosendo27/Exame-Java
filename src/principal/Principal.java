
package principal;
import java.util.Calendar;

class Exame {
    public String nomePaciente;
    public String tipoSanguineo;
    private int anoNascimento;

    public Exame(String nomePaciente, String tipoSanguineo, int anoNascimento) {
        this.nomePaciente = nomePaciente;
        this.tipoSanguineo = tipoSanguineo;
        this.anoNascimento = anoNascimento;
    }

    public int calcularIdade() {
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        return anoAtual - anoNascimento;
    }

    public void classificarResultado() {
        // método da subclasse
    }

    public void mostrarResultado() {
        // método da subclasse
    }
    public String getNomePaciente() {
        return nomePaciente;
    }
     public String getTipoSanguineo() {
        return tipoSanguineo;
    }
}

// Classe específica para exames de Glicemia

class ExameGlicemia extends Exame {
    private double quantidadeGlicose;

    public ExameGlicemia(String nomePaciente, String tipoSanguineo, int anoNascimento, double quantidadeGlicose) {
        super(nomePaciente, tipoSanguineo, anoNascimento);
        this.quantidadeGlicose = quantidadeGlicose;
    }
     

    @Override
    public void classificarResultado() {
    if (quantidadeGlicose < 100) {
        System.out.println("Normoglicemia");
    } else if (quantidadeGlicose < 126) {
        System.out.println("Pré-diabetes");
    } else {
        System.out.println("Diabetes estabelecido");
    }
}

    @Override
public void mostrarResultado() {
    System.out.println("Resultado de Glicemia: " + quantidadeGlicose + " mg/l");
}
}
// Classe específica para exames de Colesterol
class ExameColesterol extends Exame {
    private double quantidadeLDL;
    private double quantidadeHDL;
    private String risco;

    public ExameColesterol(String nomePaciente, String tipoSanguineo, int anoNascimento, double quantidadeLDL, double quantidadeHDL) {
        super(nomePaciente, tipoSanguineo, anoNascimento);
        this.quantidadeLDL = quantidadeLDL;
        this.quantidadeHDL = quantidadeHDL;
    }

    @Override
   public void classificarResultado() {
        if (calcularIdade() <= 19) {
            if (quantidadeHDL > 45) {
                risco = "Baixo";
            } else {
                risco = "Médio";
            }
        }  else {
            if (quantidadeHDL > 40) {
                risco = "Baixo";
            } else {
                risco = "Médio";
            } 
        }

        if (risco == "Baixo") {
            if (quantidadeLDL < 100) {
                risco = "Baixo";
            } else if (quantidadeLDL < 70) {
                risco = "Médio";
            } else {
                risco = "Alto";
            }
        } else if (risco == "Médio") {
            if (quantidadeLDL < 70) {
                risco = "Médio";
            } else {
                risco = "Alto";
            }
        } else {
            if (quantidadeLDL < 50) {
                risco = "Alto";
            }
        }
    }

    @Override
    public void mostrarResultado() {
        System.out.println("Resultado de Colesterol:");
        System.out.println("HDL: " + quantidadeHDL + " mg/dL");
        System.out.println("LDL: " + quantidadeLDL + " mg/dL");
        System.out.println("Risco: " + risco);
    }
}
// Classe específica para exames de Triglicerídeos
class ExameTriglicerideos extends Exame {
    private double quantidadeTriglicerideos;

    public ExameTriglicerideos(String nomePaciente, String tipoSanguineo, int anoNascimento, double quantidadeTriglicerideos) {
        super(nomePaciente, tipoSanguineo, anoNascimento);
        this.quantidadeTriglicerideos = quantidadeTriglicerideos;
    }

    @Override
    public void classificarResultado() {
        int idade = calcularIdade();

        if (idade >= 0 && idade < 10) {
            if (quantidadeTriglicerideos < 75) {
                // Classificar como OK
            } else {
                // Classificar como Elevado
            }
        } else if (idade >= 10 && idade < 20) {
            if (quantidadeTriglicerideos < 90) {
                // Classificar como OK
            } else {
                // Classificar como Elevado
            }
        } else {
            if (quantidadeTriglicerideos < 150) {
                // Classificar como OK
            } else {
                // Classificar como Elevado
            }
        }
    }

    @Override
    public void mostrarResultado() {
        System.out.println("Resultado de Triglicerídeos:");
        System.out.println("Quantidade: " + quantidadeTriglicerideos + " mg/dL");
        System.out.println("Classificação: " + getClassificacao());
    }

    private String getClassificacao() {
        classificarResultado(); // Chamar a classificação para definir o valor da classificação

        int idade = calcularIdade();
        if (idade >= 0 && idade < 10) {
            if (quantidadeTriglicerideos < 75) {
                return "OK";
            } else {
                return "Elevado";
            }
        } else if (idade >= 10 && idade < 20) {
            if (quantidadeTriglicerideos < 90) {
                return "OK";
            } else {
                return "Elevado";
            }
        } else {
            if (quantidadeTriglicerideos < 150) {
                return "OK";
            } else {
                return "Elevado";
            }
        }
    }
}

public class Principal {

    public static void main(String[] args) {
    
        ExameGlicemia exameGlicemia = new ExameGlicemia("César", "A+", 2005, 120.5);
        ExameColesterol exameColesterol = new ExameColesterol("Robertinho", "B-", 1980, 50, 35);
        ExameTriglicerideos exameTriglicerideos = new ExameTriglicerideos("Rogerinho", "O+", 1999, 45);

        // Chamar os métodos para classificar e mostrar resultados
        System.out.println("Exame de Glicemia do paciente: " + exameGlicemia.getNomePaciente());
        System.out.println("Idade: " + exameGlicemia.calcularIdade() + " - " + "Tipo Sanguíneo: " + exameGlicemia.getTipoSanguineo());
        exameGlicemia.classificarResultado();
        exameGlicemia.mostrarResultado();
        System.out.println(); 

        System.out.println("Exame de Colesterol do paciente: " + exameColesterol.getNomePaciente());
        System.out.println("Idade: " + exameColesterol.calcularIdade() + " - " + "Tipo Sanguíneo: " + exameColesterol.getTipoSanguineo());
        exameColesterol.classificarResultado();
        exameColesterol.mostrarResultado();
        System.out.println(); 

        System.out.println("Exame de Triglicerideos do paciente: " + exameTriglicerideos.getNomePaciente());
        System.out.println("Idade: " + exameTriglicerideos.calcularIdade() + " - " + "Tipo Sanguíneo: " + exameTriglicerideos.getTipoSanguineo());
        exameTriglicerideos.classificarResultado();
        exameTriglicerideos.mostrarResultado();
        System.out.println(); 
    }
        

    }

