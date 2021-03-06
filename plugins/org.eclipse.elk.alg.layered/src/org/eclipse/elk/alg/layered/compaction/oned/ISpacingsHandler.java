/*******************************************************************************
 * Copyright (c) 2016 Kiel University and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Kiel University - initial API and implementation
 *******************************************************************************/
package org.eclipse.elk.alg.layered.compaction.oned;

/**
 * An implementation of this class is able to report both the vertical and the horizontal spacing
 * between any pair of {@link CNode}s. Different implementations of {@link CNode}s may have
 * different special requirements. In such a case a special spacings handler should be implemented.
 * For a default implementation, use the {@link #DEFAULT_SPACING_HANDLER}. It returns for either spacing
 * the maximum of the two spacings returned by the nodes (e.g. {@link CNode#getVerticalSpacing()}).

 * @param <T> Some subclass of a {@link CNode}.
 */
public interface ISpacingsHandler<T extends CNode> {

    /**
     * @param cNode1
     *            the first involved node.
     * @param cNode2
     *            the second involved node.
     * @return the horizontal spacing that should be preserve between the two passed nodes.
     */
    double getHorizontalSpacing(final T cNode1, final T cNode2);

    /**
     * @param cNode1
     *            the first involved node.
     * @param cNode2
     *            the second involved node.
     * @return the vertical spacing that should be preserved between the two passed nodes.
     */
    double getVerticalSpacing(final T cNode1, final T cNode2);

    /**
     * A default implementation, returning for either spacing the maximum of the two desired
     * spacings.
     */
    ISpacingsHandler<? super CNode> DEFAULT_SPACING_HANDLER = new ISpacingsHandler<CNode>() {
        @Override
        public double getHorizontalSpacing(final CNode cNode1, final CNode cNode2) {
            return Math.max(cNode1.getHorizontalSpacing(), cNode2.getHorizontalSpacing());
        }

        @Override
        public double getVerticalSpacing(final CNode cNode1, final CNode cNode2) {
            return Math.max(cNode1.getVerticalSpacing(), cNode2.getVerticalSpacing());
        }
    };
}
