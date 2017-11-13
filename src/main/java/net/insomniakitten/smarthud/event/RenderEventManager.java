package net.insomniakitten.smarthud.event;
 
/*
 *  Copyright 2017 InsomniaKitten
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

import net.insomniakitten.smarthud.SmartHUD;
import net.insomniakitten.smarthud.feature.hotbar.HotbarManager;
import net.insomniakitten.smarthud.feature.hotbar.HotbarRenderer;
import net.insomniakitten.smarthud.feature.pickup.PickupManager;
import net.insomniakitten.smarthud.feature.pickup.PickupRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = SmartHUD.ID, value = Side.CLIENT)
public final class RenderEventManager {

    private RenderEventManager() {}

    @SubscribeEvent
    protected static void onRenderGameOverlayPre(RenderGameOverlayEvent.Pre event) {
        if (HotbarManager.canRender(event)) HotbarRenderer.renderHotbarHUD(event);
        if (PickupManager.canRender(event)) PickupRenderer.renderPickupHUD(event);
    }

    @SubscribeEvent
    protected static void onRenderGameOverlayPost(RenderGameOverlayEvent.Post event) {
        if (HotbarManager.canRender(event)) HotbarRenderer.onRenderAttackIndicator(event);
    }

}