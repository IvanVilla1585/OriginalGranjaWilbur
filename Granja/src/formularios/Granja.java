
import listas.*;
import nodos.*;
import logica.*;
import org.jvnet.substance.SubstanceLookAndFeel;
import javax.swing.JFrame;
import java.io.*; 
 
public class Granja {
	
	public static ListaAnimales listaAnimal;
	public static ListaPartos listaPartos;
	public static ListaPerfil listaPerfil;
	public static ListaPersonal listaPersonal;

    
    public static void main(String[] args) {
    	
    /*	JFrame.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo) 
		SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");*/
 
    	
    	listaAnimal = new ListaAnimales();
		listaPartos = new ListaPartos();
		listaPerfil = new ListaPerfil();
		listaPersonal= new ListaPersonal();
   	
    	DatosPersonal persona = new DatosPersonal();
    	persona.setTipoDoc("CC");
    	persona.setNumeroDocumento("8359459");
    	persona.setNombre("IVAN DARIO VILLA RAMIREZ");
    	//persona.setFechaNacimiento(15/01/1985);
    	persona.setDepartamento("ANTIOQUIA");
    	persona.setMunicipio("MEDELLIN");
    	persona.setTipoSangre("B");
    	persona.setRh("+");
    	persona.setEstado("Activo");
    //	persona.setRutaImagen();
    	persona.setDireccion("CALLE 40A NUM 35 60");
    	persona.setTelefono("2154879");
    	persona.setCorreo("trezeguet55@gmail.com");
    	persona.setTelMovil("3213658421");
    	persona.setProfesion("VETERINARIO");
    	//persona.setFechaTitulo(12/06/2010);
    	persona.setOtrosEstu("ADMINISTRACION DE EMPRESAS");
    	//persona.setFechaFin(30/07/2014);
    	persona.setObtenido("Si");
    	persona.setCargo("ADMINISTRADOR DEL AREA DE VETERINARIOS");
    	//persona.setFechaContra(03/04/2012);
    	persona.setTipoContra("TERMINO FIJO");
    	listaPersonal.guardarPersonal(persona);
    	
    	DatosPerfil perfil = new DatosPerfil();
    	perfil.setNumCedula("8359459");
    	perfil.setCodPerfil("PER-001");
    	perfil.setPerfil("ADMINISTRADOR");
    	perfil.setUsuario("IVAN-VETE");
    	perfil.setContraIngreso("1478");
    	perfil.setRepetirContraIngreso("1478");
    	perfil.setCorreoCorpora("trezeguet55@gmail.com");
    	perfil.setContra("1254");
    	perfil.setRepetirContra("1254");
    	perfil.setPregunta("MASCOTA PREFERIDA");
    	perfil.setRespuesta("ROCCO");
    	listaPerfil.guardarPerfil(perfil);
    	
    	DatosPerfil perfil1 = new DatosPerfil();
    	perfil1.setNumCedula("8359450");
    	perfil1.setCodPerfil("PER-002");
    	perfil1.setPerfil("ADMINISTRADOR DE JAULAS");
    	perfil1.setUsuario("VERO-JAULA");
    	perfil1.setContraIngreso("1456");
    	perfil1.setRepetirContraIngreso("1456");
    	perfil1.setCorreoCorpora("Verovelez@gmail.com");
    	perfil1.setContra("1255");
    	perfil1.setRepetirContra("1255");
    	perfil1.setPregunta("MASCOTA PREFERIDA");
    	perfil1.setRespuesta("LUNA");
    	listaPerfil.guardarPerfil(perfil1);
    //	ivan i= new ivan();
   // 	RecuperarClave i=new RecuperarClave();
	//	Login i=new Login(listaAnimal,listaPartos,listaPerfil,listaPersonal);
	//	MenuAdministrador Ma = new MenuAdministrador();
	//	MenuEmpleado ME=new MenuEmpleado(); 
	//	ModificarContraseña MC=new ModificarContraseña(listaPerfil,listaPersonal);   
   	//	GestionarPerfil GP=new GestionarPerfil();
	// 	AsignacionJaulas AJ=new AsignacionJaulas();
    //	AlimentosJaula AJ=new AlimentosJaula();
	//	GestionarAlimentos Ga=new GestionarAlimentos();
	//	GestionarMedicamentos Gm=new GestionarMedicamentos();
	//	GestionarReportes GR=new GestionarReportes();
	//	GestionarBackup GB=new GestionarBackup();
	//	MaestroDepartamentos MD=new MaestroDepartamentos();
	//	MaestroMunicipios MM=new MaestroMunicipios();
	//	MaestroRazas MR=new MaestroRazas();
	//	MaestroVacunas MV=new MaestroVacunas();
	//	MaestroAgentesInfec MA=new MaestroAgentesInfec();
	//	MaestroJaulas MJ=new MaestroJaulas();
	//	MaestroPermisos MP= new MaestroPermisos();
	//	MaestroEtapas ME=new MaestroEtapas();
	//	GestionarPersonal GPe=new GestionarPersonal(listaPersonal);
	//	TrazabilidadAnimal TA=new TrazabilidadAnimal();
	//	Catalogo C=new Catalogo(); 
 	//	GestionarAnimal Gani=new GestionarAnimal(listaAnimal,listaPartos);
		AcercaDe Ad=new AcercaDe();
	//	Menu_Principal MeP= new Menu_Principal();

    }
}
