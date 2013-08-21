package particle;


import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Random;


import opengl.util.Util;

import org.lwjgl.BufferUtils;

import pa.util.math.MathUtil;

public class ParticleFactory {
    private static Random rng = new Random();
		
	public static float[] generateCoordinates() {
        float maxRadius = 0.35f;
        float radius = rng.nextFloat() * maxRadius - maxRadius / 2.0f;
        float phi    = rng.nextFloat() * Util.PI_MUL2;
        float theta  = rng.nextFloat() * Util.PI_DIV2;
        
	    return new float[]{
    	            radius * MathUtil.cos(theta) * MathUtil.cos(phi), 
                    radius * MathUtil.cos(theta) * MathUtil.sin(phi) - 0.5f, 
                    radius * MathUtil.sin(theta)
                };
	}
	
	public static float generateLifetime() {
	    return rng.nextFloat() * 8000 + 2000;
	}

    public static FloatBuffer createZeroFloatBuffer(int capacity) {
        FloatBuffer fb = BufferUtils.createFloatBuffer(capacity);
        for(int i = 0; i < fb.capacity(); i++) {
            fb.put(0);
        }
        fb.rewind();
        return fb;
    }
	
    private ParticleFactory() {}
}
