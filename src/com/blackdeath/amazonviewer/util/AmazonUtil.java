package com.blackdeath.amazonviewer.util;

import java.util.Scanner;

/**
 * @author Seth Luis
 *
 */
public class AmazonUtil {
	
	public static int leeRespuesta() {
		int respuesta = -1;

		Scanner sc = new Scanner(System.in);
		String respuestaStr = sc.nextLine();

		if (isRespuestaValida(respuestaStr)) {
			respuesta = Integer.parseInt(respuestaStr);
		}

		return respuesta;
	}

	private static boolean isRespuestaValida(String respuesta) {
		return "0".equals(respuesta) || "1".equals(respuesta) || "2".equals(respuesta) || "3".equals(respuesta)
				|| "4".equals(respuesta) || "5".equals(respuesta) || "6".equals(respuesta);
	}
}
