package enviodecorreo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Correo {
	private String correoDeOrigen;
    private String correoDeDestino;
    private String asunto;
    private String mensajeDeTexto;
    private String contrasenia16Digitos;
            
  public Correo(String origen,String destino,String contra16Digitos){
   this.correoDeOrigen = origen;
   this.correoDeDestino = destino;
   this.asunto = "Gracias por comprar en nuestro cine!";
   this.mensajeDeTexto = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n"
   		+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\r\n"
   		+ "<head>\r\n"
   		+ "<meta charset=\"UTF-8\">\r\n"
   		+ "<meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\r\n"
   		+ "<meta name=\"x-apple-disable-message-reformatting\">\r\n"
   		+ "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
   		+ "<meta content=\"telephone=no\" name=\"format-detection\">\r\n"
   		+ "<title>Nueva plantilla de correo electr%C3%B3nico 2022-06-08</title><!--[if (mso 16)]>\r\n"
   		+ "<style type=\"text/css\">\r\n"
   		+ "a {text-decoration: none;}\r\n"
   		+ "</style>\r\n"
   		+ "<![endif]--><!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--><!--[if gte mso 9]>\r\n"
   		+ "<xml>\r\n"
   		+ "<o:OfficeDocumentSettings>\r\n"
   		+ "<o:AllowPNG></o:AllowPNG>\r\n"
   		+ "<o:PixelsPerInch>96</o:PixelsPerInch>\r\n"
   		+ "</o:OfficeDocumentSettings>\r\n"
   		+ "</xml>\r\n"
   		+ "<![endif]-->\r\n"
   		+ "<style type=\"text/css\">\r\n"
   		+ "#outlook a {\r\n"
   		+ "padding:0;\r\n"
   		+ "}\r\n"
   		+ ".ExternalClass {\r\n"
   		+ "width:100%;\r\n"
   		+ "}\r\n"
   		+ ".ExternalClass,\r\n"
   		+ ".ExternalClass p,\r\n"
   		+ ".ExternalClass span,\r\n"
   		+ ".ExternalClass font,\r\n"
   		+ ".ExternalClass td,\r\n"
   		+ ".ExternalClass div {\r\n"
   		+ "line-height:100%;\r\n"
   		+ "}\r\n"
   		+ ".es-button {\r\n"
   		+ "mso-style-priority:100!important;\r\n"
   		+ "text-decoration:none!important;\r\n"
   		+ "}\r\n"
   		+ "a[x-apple-data-detectors] {\r\n"
   		+ "color:inherit!important;\r\n"
   		+ "text-decoration:none!important;\r\n"
   		+ "font-size:inherit!important;\r\n"
   		+ "font-family:inherit!important;\r\n"
   		+ "font-weight:inherit!important;\r\n"
   		+ "line-height:inherit!important;\r\n"
   		+ "}\r\n"
   		+ ".es-desk-hidden {\r\n"
   		+ "display:none;\r\n"
   		+ "float:left;\r\n"
   		+ "overflow:hidden;\r\n"
   		+ "width:0;\r\n"
   		+ "max-height:0;\r\n"
   		+ "line-height:0;\r\n"
   		+ "mso-hide:all;\r\n"
   		+ "}\r\n"
   		+ "[data-ogsb] .es-button {\r\n"
   		+ "border-width:0!important;\r\n"
   		+ "padding:10px 20px 10px 20px!important;\r\n"
   		+ "}\r\n"
   		+ "@media only screen and (max-width:600px) {p, ul li, ol li, a { line-height:150%!important } h1, h2, h3, h1 a, h2 a, h3 a { line-height:120%!important } h1 { font-size:30px!important; text-align:center } h2 { font-size:26px!important; text-align:center } h3 { font-size:20px!important; text-align:center } .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a { font-size:30px!important } .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a { font-size:26px!important } .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a { font-size:20px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:16px!important } .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a { font-size:16px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:16px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:block!important } a.es-button, button.es-button { font-size:20px!important; display:block!important; border-width:10px 0px 10px 0px!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } .es-menu td { width:1%!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } .es-menu td a { font-size:16px!important } }\r\n"
   		+ "</style>\r\n"
   		+ "</head>\r\n"
   		+ "<body style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\r\n"
   		+ "<div class=\"es-wrapper-color\" style=\"background-color:#F6F6F6\"><!--[if gte mso 9]>\r\n"
   		+ "<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\r\n"
   		+ "<v:fill type=\"tile\" color=\"#f6f6f6\"></v:fill>\r\n"
   		+ "</v:background>\r\n"
   		+ "<![endif]-->\r\n"
   		+ "<table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td valign=\"top\" style=\"padding:0;Margin:0\">\r\n"
   		+ "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"center\" style=\"padding:0;Margin:0\">\r\n"
   		+ "<table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#31cb4b;width:600px\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#31cb4b\" align=\"center\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px;background-color:#93c47d\" bgcolor=\"#93c47d\" align=\"left\">\r\n"
   		+ "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\r\n"
   		+ "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"center\" style=\"padding:0;Margin:0\"><h2 style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-size:30px;font-style:normal;font-weight:normal;color:#ffffff\">NUESTRO CINE</h2></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table>\r\n"
   		+ "<table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"center\" style=\"padding:0;Margin:0\">\r\n"
   		+ "<table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"left\" style=\"Margin:0;padding-top:10px;padding-bottom:10px;padding-left:15px;padding-right:15px\">\r\n"
   		+ "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:570px\">\r\n"
   		+ "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:5px;padding-top:15px\"><h2 style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-size:30px;font-style:normal;font-weight:normal;color:#333333\">ENTRADAS RESERVADAS!</h2></td>\r\n"
   		+ "</tr>\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:10px;padding-left:20px;padding-right:20px;font-size:0px\">\r\n"
   		+ "<table width=\"15%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td style=\"padding:0;Margin:0;border-bottom:4px solid #0b5394;background:none 0% 0% repeat scroll #FFFFFF;height:1px;width:100%;margin:0px\"></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"left\" style=\"padding:0;Margin:0\">\r\n"
   		+ "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\">\r\n"
   		+ "<table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#ffffff\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" role=\"presentation\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><img class=\"adapt-img\" src=\"https://wnezij.stripocdn.email/content/guids/videoImgGuid/images/enestepac3adsvolverc3a1nhabercinescomercialesdespuc3a9sde30ac3b1os1280x720.jpeg\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"600\"></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;padding-bottom:40px\">\r\n"
   		+ "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\r\n"
   		+ "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:10px;padding-top:25px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#333333;font-size:16px\">Recorda presentarte con tu dni para retirarlas en boleteria</p></td>\r\n"
   		+ "</tr>\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#333333;font-size:16px\"><br></p></td>\r\n"
   		+ "</tr>\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td esdev-links-color=\"#333333\" align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><br></p></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table>\r\n"
   		+ "<table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"center\" style=\"padding:0;Margin:0\">\r\n"
   		+ "<table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"left\" style=\"Margin:0;padding-bottom:10px;padding-top:20px;padding-left:20px;padding-right:20px\">\r\n"
   		+ "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\r\n"
   		+ "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"center\" style=\"Margin:0;padding-top:5px;padding-bottom:10px;padding-left:10px;padding-right:10px;font-size:0\">\r\n"
   		+ "<table width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td style=\"padding:0;Margin:0;border-bottom:1px solid #cccccc;background:none;height:1px;width:100%;margin:0px\"></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td esdev-links-color=\"#666666\" align=\"center\" style=\"padding:0;Margin:0;padding-top:5px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#666666;font-size:14px\">Bluff St. Woodville, USA</p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#666666;font-size:14px\"><a target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#666666;font-size:14px\" href=\"https://viewstripo.email\">123456789</a>, <a target=\"_blank\" href=\"mailto:your@mail.com\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#666666;font-size:14px\">your@mail.com</a></p></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table>\r\n"
   		+ "<table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\"></tr>\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"center\" style=\"padding:0;Margin:0\">\r\n"
   		+ "<table class=\"es-footer-body\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"left\" style=\"Margin:0;padding-top:5px;padding-bottom:15px;padding-left:20px;padding-right:20px\">\r\n"
   		+ "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\r\n"
   		+ "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:18px;color:#666666;font-size:12px\">You are receiving this email because you have visited our site or asked us about regular newsletter.</p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:18px;color:#666666;font-size:12px\"><a target=\"_blank\" class=\"unsubscribe\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#666666;font-size:12px;line-height:18px\" href=\"\">Unsubscribe</a>&nbsp; | <a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#666666;font-size:12px\">Update Preferences</a> | <a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#666666;font-size:12px\">Customer Support</a></p></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table>\r\n"
   		+ "<table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"center\" style=\"padding:0;Margin:0\">\r\n"
   		+ "<table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td align=\"left\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px\">\r\n"
   		+ "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\r\n"
   		+ "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\r\n"
   		+ "<tr style=\"border-collapse:collapse\">\r\n"
   		+ "<td class=\"es-infoblock made_with\" align=\"center\" style=\"padding:0;Margin:0;line-height:120%;font-size:0;color:#CCCCCC\"><a target=\"_blank\" href=\"https://viewstripo.email/?utm_source=templates&utm_medium=email&utm_campaign=restaurants&utm_content=independence_day\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#999999;font-size:12px\"><img src=\"https://wnezij.stripocdn.email/content/guids/CABINET_9df86e5b6c53dd0319931e2447ed854b/images/64951510234941531.png\" alt width=\"125\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table></td>\r\n"
   		+ "</tr>\r\n"
   		+ "</table>\r\n"
   		+ "</div>\r\n"
   		+ "</body>\r\n"
   		+ "</html>";
   this.contrasenia16Digitos = contra16Digitos;
   
  }
  public void envioDeCorreos(){
      envioDeMensajes();
  }
  
  private void envioDeMensajes(){
      try{
  Properties p = new Properties();  
        p.put("mail.smtp.host", "smtp.office365.com");
        p.setProperty("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.ssl.trust", "smtp.office365.com");
        p.setProperty("mail.smtp.port", "587");
        p.setProperty("mail.smtp.user",correoDeOrigen);
        p.setProperty("mail.smtp.auth", "true");
        Session s = Session.getDefaultInstance(p); 
        MimeMessage mensaje = new MimeMessage(s);
        mensaje.setFrom(new InternetAddress(correoDeOrigen));
        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDeDestino));
        mensaje.setSubject(asunto);
        mensaje.setContent(mensajeDeTexto, "text/html; charset=utf-8");
            
          Transport t = s.getTransport("smtp");
          t.connect(correoDeOrigen,contrasenia16Digitos);
          t.sendMessage(mensaje, mensaje.getAllRecipients());
          t.close();
          System.out.println("Mensaje enviado");
          } catch (MessagingException e) {
           
        }
  }
}

