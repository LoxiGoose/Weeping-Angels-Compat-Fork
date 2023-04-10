package mc.craig.software.angels.forge.compat.tardis;

import mc.craig.software.angels.forge.compat.tardis.exteriors.AbPropModel;
import mc.craig.software.angels.forge.compat.tardis.interiordoors.AbPropIntDoorModel;
import mc.craig.software.angels.forge.compat.tardis.registry.TardisBlocks;
import mc.craig.software.angels.forge.compat.tardis.registry.TardisTiles;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TardisClient {
    public static void clientStuff() {
        // Render Stuff
        ItemBlockRenderTypes.setRenderLayer(TardisBlocks.EXTERIOR_2005.get(), RenderType.translucent());
        //Exteriors
        EnumDoorTypes.ABPROP.setInteriorDoorModel(new AbPropIntDoorModel(AbPropIntDoorModel.createBodyLayer().bakeRoot()));
    }

    @SubscribeEvent
    public static void registerModel(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(AbPropModel.LAYER_LOCATION, AbPropModel::createBodyLayer);
        event.registerLayerDefinition(AbPropIntDoorModel.LAYER_LOCATION, AbPropIntDoorModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerTileRenderers(EntityRenderersEvent.RegisterRenderers BlockEvent) {
        BlockEvent.registerBlockEntityRenderer(TardisTiles.EXTERIOR_2005.get(), AbPropRenderer::new);
    }
}