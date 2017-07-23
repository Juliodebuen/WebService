/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasificador;

import javax.jws.WebService;

/**
 *
 * @author julio
 */
@WebService(serviceName = "ClasificadorWSDLService", portName = "ClasificadorWSDLPort", endpointInterface = "org.netbeans.j2ee.wsdl.clasificador.clasificador.clasificadorwsdl.ClasificadorWSDLPortType", targetNamespace = "http://j2ee.netbeans.org/wsdl/Clasificador/Clasificador/ClasificadorWSDL", wsdlLocation = "WEB-INF/wsdl/ClasificadorService/ClasificadorWSDL.wsdl")
public class ClasificadorService {

    public java.lang.String clasificadorWSDLOperation(byte image) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
