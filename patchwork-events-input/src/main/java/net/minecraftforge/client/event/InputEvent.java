/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2020, 2019-2020
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.client.event;

import net.minecraftforge.eventbus.api.Event;
import org.lwjgl.glfw.GLFW;

public class InputEvent extends Event {
	/**
	 * A cancellable mouse event fired before key bindings are updated.
	 */
	public static class RawMouseEvent extends InputEvent {
		private final int action;
		private final int button;
		private final int mods;

		// For EventBus
		public RawMouseEvent() {
			this(-1, -1, -1);
		}

		public RawMouseEvent(int button, int action, int mods) {
			this.button = button;
			this.action = action;
			this.mods = mods;
		}

		/**
		 * The mouse button that triggered this event.
		 * https://www.glfw.org/docs/latest/group__buttons.html
		 *
		 * @see GLFW mouse constants starting with "GLFW_MOUSE_BUTTON_"
		 */
		public int getButton() {
			return this.button;
		}

		/**
		 * Integer representing the mouse button's action.
		 *
		 * @see GLFW#GLFW_PRESS
		 * @see GLFW#GLFW_RELEASE
		 */
		public int getAction() {
			return this.action;
		}

		/**
		 * Bit field representing the modifier keys pressed.
		 * https://www.glfw.org/docs/latest/group__mods.html
		 *
		 * @see GLFW#GLFW_MOD_SHIFT
		 * @see GLFW#GLFW_MOD_CONTROL
		 * @see GLFW#GLFW_MOD_ALT
		 * @see GLFW#GLFW_MOD_SUPER
		 */
		public int getMods() {
			return this.mods;
		}

		@Override
		public boolean isCancelable() {
			return true;
		}
	}

	/**
	 * This event fires when a mouse input is detected.
	 */
	public static class MouseInputEvent extends InputEvent {
		private final int button;
		private final int action;
		private final int mods;

		// For EventBus
		public MouseInputEvent() {
			this(-1, -1, -1);
		}

		public MouseInputEvent(int button, int action, int mods) {
			this.button = button;
			this.action = action;
			this.mods = mods;
		}

		/**
		 * The mouse button that triggered this event.
		 * https://www.glfw.org/docs/latest/group__buttons.html
		 *
		 * @see GLFW mouse constants starting with "GLFW_MOUSE_BUTTON_"
		 */
		public int getButton() {
			return this.button;
		}

		/**
		 * Integer representing the mouse button's action.
		 *
		 * @see GLFW#GLFW_PRESS
		 * @see GLFW#GLFW_RELEASE
		 */
		public int getAction() {
			return this.action;
		}

		/**
		 * Bit field representing the modifier keys pressed.
		 * https://www.glfw.org/docs/latest/group__mods.html
		 *
		 * @see GLFW#GLFW_MOD_SHIFT
		 * @see GLFW#GLFW_MOD_CONTROL
		 * @see GLFW#GLFW_MOD_ALT
		 * @see GLFW#GLFW_MOD_SUPER
		 */
		public int getMods() {
			return this.mods;
		}
	}

	/**
	 * This event fires when the mouse scroll wheel is used outside of a gui.
	 */
	public static class MouseScrollEvent extends InputEvent {
		private final double scrollDelta;
		private final double mouseX;
		private final double mouseY;
		private final boolean leftDown;
		private final boolean middleDown;
		private final boolean rightDown;

		// For EventBus
		public MouseScrollEvent() {
			this(-1, false, false, false, -1, -1);
		}

		public MouseScrollEvent(double scrollDelta, boolean leftDown, boolean middleDown, boolean rightDown, double mouseX, double mouseY) {
			this.scrollDelta = scrollDelta;
			this.leftDown = leftDown;
			this.middleDown = middleDown;
			this.rightDown = rightDown;
			this.mouseX = mouseX;
			this.mouseY = mouseY;
		}

		public double getScrollDelta() {
			return this.scrollDelta;
		}

		public boolean isLeftDown() {
			return this.leftDown;
		}

		public boolean isRightDown() {
			return this.rightDown;
		}

		public boolean isMiddleDown() {
			return this.middleDown;
		}

		public double getMouseX() {
			return this.mouseX;
		}

		public double getMouseY() {
			return this.mouseY;
		}

		@Override
		public boolean isCancelable() {
			return true;
		}
	}

	/**
	 * This event fires when a keyboard input is detected.
	 */
	public static class KeyInputEvent extends InputEvent {
		private final int key;
		private final int scanCode;
		private final int action;
		private final int modifiers;

		// For EventBus
		public KeyInputEvent() {
			this(-1, -1, -1, -1);
		}

		public KeyInputEvent(int key, int scanCode, int action, int modifiers) {
			this.key = key;
			this.scanCode = scanCode;
			this.action = action;
			this.modifiers = modifiers;
		}

		/**
		 * The keyboard key that triggered this event.
		 * https://www.glfw.org/docs/latest/group__keys.html
		 *
		 * @see GLFW key constants starting with "GLFW_KEY_"
		 */
		public int getKey() {
			return this.key;
		}

		/**
		 * Platform-specific scan code.
		 * Used for {@link InputMappings#getInputByCode(int, int)}
		 *
		 * <p>The scan code is unique for every key, regardless of whether it has a key code.
		 * Scan codes are platform-specific but consistent over time, so keys will have different scan codes depending
		 * on the platform but they are safe to save to disk as custom key bindings.
		 */
		public int getScanCode() {
			return this.scanCode;
		}

		/**
		 * Integer representing the key's action.
		 *
		 * @see GLFW#GLFW_PRESS
		 * @see GLFW#GLFW_RELEASE
		 * @see GLFW#GLFW_REPEAT
		 */
		public int getAction() {
			return this.action;
		}

		/**
		 * Bit field representing the modifier keys pressed.
		 * https://www.glfw.org/docs/latest/group__mods.html
		 *
		 * @see GLFW#GLFW_MOD_SHIFT
		 * @see GLFW#GLFW_MOD_CONTROL
		 * @see GLFW#GLFW_MOD_ALT
		 * @see GLFW#GLFW_MOD_SUPER
		 */
		public int getModifiers() {
			return this.modifiers;
		}
	}
}
