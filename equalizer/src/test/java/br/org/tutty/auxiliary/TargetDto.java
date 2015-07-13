package br.org.tutty.auxiliary;

import br.org.tutty.Equalization;

/**
 * Created by drferreira on 10/07/15.
 */
public class TargetDto {

    @Equalization(name = "testAnnotation")
    public String targetShouldFillTargetValues = "9";

    @Equalization(name = "testAnnotationTarget")
    public String targetShouldDontFillDistinctNames = "8";

    @Equalization(name = "targetShouldIgnoreFieldName")
    public String shouldIgnoreFieldName = "7";

    @Equalization(name = "shouldFillObjectWithTypeSpecific")
    public OtherDto type  = new OtherDto();

    public String withoutAnnotation = "Target";

}
