import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 PdfManager pdfManager = new PdfManager();
	       pdfManager.setFilePath("C://Users//Qureshi//Desktop//Rozee.pk.pdf");
	       System.out.println(pdfManager.ToText()); 
		//Change on the Website
	}

}
