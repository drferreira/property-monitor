## Source
> `public class Source {`<br>
>     `@Equalization(name = "alias")`<br>
>     `public String fieldSource = "value";`<br>
> `}`

## Target
> `public class Source {`<br>
>     `@Equalization(name = "alias")`<br>
>     `public String fieldTarget = "OtherValue";`<br>
> `}`

`> TargetDto target = new TargetDto();` <br>
`> SourceDto source = new SourceDto();`<br>
<br>
`> Equalizer.equalize(target, source);`<br>

## Result
target.fieldTarget : The previous value was lost and the current value is "value".

