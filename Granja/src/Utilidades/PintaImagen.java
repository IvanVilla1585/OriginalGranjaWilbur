package Utilidades;


import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;



public class PintaImagen implements Border
{
	private   BufferedImage image ;

	public PintaImagen(BufferedImage image )
		{
			  /*
			   * This allows to specify the color for the bullet.
			   * If <code>null</code> (default), the foreground color
			   * of the component is used where the icon is drawn.
			   */
			this.image=image;
		}


		/*
		* Here's where the actual drawing occurs. Producing a paintBorder shape
		* is very simple. Just two intersecting rectangles and that's all:
		* <pre>
		*     int x0=x+ (width-image.getWidth())/2;
		*    int y0 = y+ (height-image.getHeight())/2;
		*	 g.drawImage(image,x0,y0,null);
		* </pre>
		*/


		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
			{
				/*
				* The paintBorder width.
				* @return 0 (pixels)
				*/

				int x0 = x+ (width-image.getWidth())/2;
				int y0 = y+ (height-image.getHeight())/2;
				g.drawImage(image,x0,y0,null);
			}

			public Insets getBorderInsets(Component c)
				{
					return new Insets(0,0,0,0);
				/*
				* The getBorderInsets width.
				* @return 0,0,0,0 (pixels)
				*/

				}

				public boolean isBorderOpaque()
					{
						return true;

					/*
					* The IsBorderOpaque width.
					* @return true
					*/

					}


}
