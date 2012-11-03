package org.solovyev.android.view.drag;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;
import java.util.Map;

/**
 * User: serso
 * Date: 11/3/12
 * Time: 1:57 PM
 */
public class DirectionDragButtonDefImpl implements DirectionDragButtonDef {

    @Nullable
    private CharSequence text;

    private Map<DragDirection, CharSequence> directionsTexts = new EnumMap<DragDirection, CharSequence>(DragDirection.class);

    @Nullable
    private Integer backgroundColor;

    @Nullable
    private Integer drawableResId;

    @Nullable
    private String tag;

    private DirectionDragButtonDefImpl() {
    }

    @NotNull
    public static DirectionDragButtonDef newInstance(@Nullable CharSequence text) {
        return newInstance(text, null, null, null, null);
    }

    @NotNull
    public static DirectionDragButtonDef newInstance(@Nullable CharSequence text, @NotNull String tag) {
        DirectionDragButtonDefImpl result = (DirectionDragButtonDefImpl) newInstance(text, null, null, null, null);
        result.tag = tag;
        return result;
    }

    @NotNull
    public static DirectionDragButtonDef newInstance(@Nullable CharSequence text,
                                                     @Nullable CharSequence up,
                                                     @Nullable CharSequence right,
                                                     @Nullable CharSequence down,
                                                     @Nullable CharSequence left) {
        return newInstance(text, up, right, down, left, null);
    }

    @NotNull
    public static DirectionDragButtonDef newInstance(@Nullable CharSequence text,
                                                     @Nullable CharSequence up,
                                                     @Nullable CharSequence right,
                                                     @Nullable CharSequence down,
                                                     @Nullable CharSequence left,
                                                     @Nullable Integer backgroundColor) {
        final DirectionDragButtonDefImpl result = new DirectionDragButtonDefImpl();

        result.text = text;
        result.directionsTexts.put(DragDirection.up, up);
        result.directionsTexts.put(DragDirection.right, right);
        result.directionsTexts.put(DragDirection.down, down);
        result.directionsTexts.put(DragDirection.left, left);

        result.backgroundColor = backgroundColor;

        return result;
    }

    @NotNull
    public static DirectionDragButtonDef newDrawableInstance(@NotNull Integer drawableResId, @NotNull String tag) {
        final DirectionDragButtonDefImpl result = new DirectionDragButtonDefImpl();

        result.drawableResId = drawableResId;
        result.tag = tag;

        return result;

    }

    @Nullable
    @Override
    public CharSequence getText(@NotNull DragDirection dragDirection) {
        return directionsTexts.get(dragDirection);
    }

    @Nullable
    @Override
    public Integer getDrawableResId() {
        return this.drawableResId;
    }

    @Nullable
    @Override
    public String getTag() {
        return tag;
    }

    @Nullable
    @Override
    public Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    @Override
    public CharSequence getText() {
        return text;
    }
}