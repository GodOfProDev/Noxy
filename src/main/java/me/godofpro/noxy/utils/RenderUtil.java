package me.godofpro.noxy.utils;

import kotlin.Triple;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;

import java.awt.*;

public class RenderUtil {

    public static void drawFilledBoundingBox(AxisAlignedBB aabb, Color c, Float alpha) {
        GlStateManager.enableBlend();
        GlStateManager.disableLighting();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.disableTexture2D();

        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();

        GlStateManager.color(c.getRed() / 255f, c.getGreen() / 255f, c.getBlue() / 255f, c.getAlpha() / 255f * alpha);

        //vertical
        worldrenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION);
        worldrenderer.pos(aabb.minX, aabb.minY, aabb.minZ).endVertex();
        worldrenderer.pos(aabb.maxX, aabb.minY, aabb.minZ).endVertex();
        worldrenderer.pos(aabb.maxX, aabb.minY, aabb.maxZ).endVertex();
        worldrenderer.pos(aabb.minX, aabb.minY, aabb.maxZ).endVertex();
        tessellator.draw();
        worldrenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION);
        worldrenderer.pos(aabb.minX, aabb.maxY, aabb.maxZ).endVertex();
        worldrenderer.pos(aabb.maxX, aabb.maxY, aabb.maxZ).endVertex();
        worldrenderer.pos(aabb.maxX, aabb.maxY, aabb.minZ).endVertex();
        worldrenderer.pos(aabb.minX, aabb.maxY, aabb.minZ).endVertex();
        tessellator.draw();

        GlStateManager.color(
                c.getRed() / 255f * 0.8f,
                c.getGreen() / 255f * 0.8f,
                c.getBlue() / 255f * 0.8f,
                c.getAlpha() / 255f * alpha
        );

        //x
        worldrenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION);
        worldrenderer.pos(aabb.minX, aabb.minY, aabb.maxZ).endVertex();
        worldrenderer.pos(aabb.minX, aabb.maxY, aabb.maxZ).endVertex();
        worldrenderer.pos(aabb.minX, aabb.maxY, aabb.minZ).endVertex();
        worldrenderer.pos(aabb.minX, aabb.minY, aabb.minZ).endVertex();
        tessellator.draw();
        worldrenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION);
        worldrenderer.pos(aabb.maxX, aabb.minY, aabb.minZ).endVertex();
        worldrenderer.pos(aabb.maxX, aabb.maxY, aabb.minZ).endVertex();
        worldrenderer.pos(aabb.maxX, aabb.maxY, aabb.maxZ).endVertex();
        worldrenderer.pos(aabb.maxX, aabb.minY, aabb.maxZ).endVertex();
        tessellator.draw();

        GlStateManager.color(
                c.getRed() / 255f * 0.9f,
                c.getGreen() / 255f * 0.9f,
                c.getBlue() / 255f * 0.9f,
                c.getAlpha() / 255f * alpha
        );
        //z
        worldrenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION);
        worldrenderer.pos(aabb.minX, aabb.maxY, aabb.minZ).endVertex();
        worldrenderer.pos(aabb.maxX, aabb.maxY, aabb.minZ).endVertex();
        worldrenderer.pos(aabb.maxX, aabb.minY, aabb.minZ).endVertex();
        worldrenderer.pos(aabb.minX, aabb.minY, aabb.minZ).endVertex();
        tessellator.draw();
        worldrenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION);
        worldrenderer.pos(aabb.minX, aabb.minY, aabb.maxZ).endVertex();
        worldrenderer.pos(aabb.maxX, aabb.minY, aabb.maxZ).endVertex();
        worldrenderer.pos(aabb.maxX, aabb.maxY, aabb.maxZ).endVertex();
        worldrenderer.pos(aabb.minX, aabb.maxY, aabb.maxZ).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static Triple<Double, Double, Double> getViewerPos(Float partialTicks)
    {
        Entity viewer = Minecraft.getMinecraft().getRenderViewEntity();
        Double viewerX = viewer.lastTickPosX + (viewer.posX - viewer.lastTickPosX) * partialTicks;
        Double viewerY = viewer.lastTickPosY + (viewer.posY - viewer.lastTickPosY) * partialTicks;
        Double viewerZ = viewer.lastTickPosZ + (viewer.posZ - viewer.lastTickPosZ) * partialTicks;
        return new Triple<>(viewerX, viewerY, viewerZ);
    }

}
