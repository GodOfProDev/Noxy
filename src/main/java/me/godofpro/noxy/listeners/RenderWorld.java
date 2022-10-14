package me.godofpro.noxy.listeners;

import kotlin.Triple;
import me.godofpro.noxy.utils.RenderUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;

public class RenderWorld {

    @SubscribeEvent
    public void onRenderWorld(RenderWorldLastEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        float dist = 57.0f;
        Vec3 vec3 = mc.thePlayer.getPositionEyes(event.partialTicks);
        Vec3 vec31 = mc.thePlayer.getLook(event.partialTicks);
        Vec3 vec32 = vec3.addVector(
                vec31.xCoord * dist,
                vec31.yCoord * dist,
                vec31.zCoord * dist
        );
        MovingObjectPosition obj = mc.theWorld.rayTraceBlocks(mc.thePlayer.getPositionEyes(event.partialTicks), vec32, true, false, true);
        if (obj == null) return;
        BlockPos block = obj.getBlockPos();
        IBlockState state = mc.theWorld.getBlockState(block);
        Triple<Double, Double, Double> viewerPos = RenderUtil.getViewerPos(event.partialTicks);
        Double viewerX = viewerPos.component1();
        Double viewerY = viewerPos.component2();
        Double viewerZ = viewerPos.component3();
        RenderUtil.drawFilledBoundingBox(
                state.getBlock().getSelectedBoundingBox(
                        mc.theWorld, block
                ).expand(0.0020000000949949026, 0.0020000000949949026, 0.0020000000949949026)
                        .offset(-viewerX, -viewerY, -viewerZ),
                new Color(13, 211, 152),
                0.5f
        );
    }
}
