package br.org.tutty.auxiliary;

import br.org.tutty.Equalization;

/**
 * Created by drferreira on 10/07/15.
 */
public class SourceDto {

    @Equalization(name = "testAnnotation")
    public String sourceShouldFillTargetValues = "1";

    @Equalization(name = "testAnnotationSource")
    public String sourceShouldDontFillDistinctNames = "2";

    @Equalization(name = "sourceShouldIgnoreFieldName")
    public String shouldIgnoreFieldName = "3";

    @Equalization(name = "shouldFillObjectWithTypeSpecific")
    public OtherDto type  = new OtherDto();
}
