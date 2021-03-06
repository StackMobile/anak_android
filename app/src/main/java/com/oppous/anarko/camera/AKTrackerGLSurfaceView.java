package com.oppous.anarko.camera;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;

/** Implementation of GLSurfaceView class provided by Android.
 * 
 *  Creates and sets OpenGL renderer that contains the actual rendering code to render on this view.
 */
public class AKTrackerGLSurfaceView extends GLSurfaceView
{
	private AKTrackerRenderer mRenderer;

	AKTrackerGLSurfaceView(Context context)
	{
		super(context);
		mRenderer = new AKTrackerRenderer(context);
		
		setRenderer(mRenderer);
		setRenderMode(RENDERMODE_CONTINUOUSLY);
		setKeepScreenOn(true);
	}

}
