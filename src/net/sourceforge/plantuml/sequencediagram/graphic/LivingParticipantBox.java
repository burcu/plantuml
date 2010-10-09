/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009, Arnaud Roques
 *
 * Project Info:  http://plantuml.sourceforge.net
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * Original Author:  Arnaud Roques
 * 
 * Revision $Revision: 5114 $
 *
 */
package net.sourceforge.plantuml.sequencediagram.graphic;

import net.sourceforge.plantuml.graphic.StringBounder;
import net.sourceforge.plantuml.sequencediagram.InGroupable;
import net.sourceforge.plantuml.ugraphic.UGraphic;

public class LivingParticipantBox implements InGroupable {

	private final ParticipantBox participantBox;
	private final LifeLine lifeLine;

	public LivingParticipantBox(ParticipantBox participantBox, LifeLine lifeLine) {
		this.participantBox = participantBox;
		this.lifeLine = lifeLine;
	}

	/**
	 * @deprecated a virer
	 */
	public ParticipantBox getParticipantBox() {
		return participantBox;
	}

	/**
	 * @deprecated a virer
	 */
	public LifeLine getLifeLine() {
		return lifeLine;
	}

	public Segment getLiveThicknessAt(StringBounder stringBounder, double y) {
		final double left = lifeLine.getLeftShift(y);
		assert left >= 0;
		final double right = lifeLine.getRightShift(y);
		assert right >= 0;
		final double centerX = participantBox.getCenterX(stringBounder);
		// System.err.println("Attention, null for segment");
		return new Segment(centerX - left, centerX + right, null);
	}

	public void drawLineU(UGraphic ug, double startingY, double endingY, boolean showTail) {
		if (endingY <= startingY) {
			return;
		}
		participantBox.drawLineU(ug, startingY, endingY, showTail);
	}

	public double magicMargin(StringBounder stringBounder) {
		return participantBox.magicMargin(stringBounder);
	}

	public void create(double ypos) {
		lifeLine.setCreate(ypos);
	}

	public double getCreate() {
		return lifeLine.getCreate();
	}

	public double getMaxX(StringBounder stringBounder) {
		return participantBox.getMaxX(stringBounder);
	}

	public double getMinX(StringBounder stringBounder) {
		return participantBox.getStartingX();
	}

	public String toString(StringBounder stringBounder) {
		return toString();
	}

}