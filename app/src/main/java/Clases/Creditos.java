package Clases;

public class Creditos {


    private int CreditoHipotecario;
    private int CreditoAutomotriz;



    public Creditos()
    {
        CreditoHipotecario = 1000000;
        CreditoAutomotriz = 500000;
    }


    public int getCreditoHipotecario()
    {
        return CreditoHipotecario;
    }

    public int getCreditoAutomotriz()
    {
        return CreditoAutomotriz;
    }
}
