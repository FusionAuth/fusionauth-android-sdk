//[library](../../../index.md)/[io.fusionauth.mobilesdk.exceptions](../index.md)/[AuthorizationException](index.md)

# AuthorizationException

[androidJvm]\
class [AuthorizationException](index.md) : [Exception](https://developer.android.com/reference/kotlin/java/lang/Exception.html)

## Constructors

| | |
|---|---|
| [AuthorizationException](-authorization-exception.md) | [androidJvm]<br>constructor(message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))constructor(message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), cause: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html))constructor(exception: AuthorizationException)constructor(cause: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html))constructor() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [cause](../-storage-exception/index.md#-654012527%2FProperties%2F-435046686) | [androidJvm]<br>open val [cause](../-storage-exception/index.md#-654012527%2FProperties%2F-435046686): [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? |
| [message](../-storage-exception/index.md#1824300659%2FProperties%2F-435046686) | [androidJvm]<br>open val [message](../-storage-exception/index.md#1824300659%2FProperties%2F-435046686): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |

## Functions

| Name | Summary |
|---|---|
| [addSuppressed](../-storage-exception/index.md#282858770%2FFunctions%2F-435046686) | [androidJvm]<br>fun [addSuppressed](../-storage-exception/index.md#282858770%2FFunctions%2F-435046686)(p0: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) |
| [fillInStackTrace](../-storage-exception/index.md#-1102069925%2FFunctions%2F-435046686) | [androidJvm]<br>open fun [fillInStackTrace](../-storage-exception/index.md#-1102069925%2FFunctions%2F-435046686)(): [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html) |
| [getLocalizedMessage](../-storage-exception/index.md#1043865560%2FFunctions%2F-435046686) | [androidJvm]<br>open fun [getLocalizedMessage](../-storage-exception/index.md#1043865560%2FFunctions%2F-435046686)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getStackTrace](../-storage-exception/index.md#2050903719%2FFunctions%2F-435046686) | [androidJvm]<br>open fun [getStackTrace](../-storage-exception/index.md#2050903719%2FFunctions%2F-435046686)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[StackTraceElement](https://developer.android.com/reference/kotlin/java/lang/StackTraceElement.html)&gt; |
| [getSuppressed](../-storage-exception/index.md#672492560%2FFunctions%2F-435046686) | [androidJvm]<br>fun [getSuppressed](../-storage-exception/index.md#672492560%2FFunctions%2F-435046686)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)&gt; |
| [initCause](../-storage-exception/index.md#-418225042%2FFunctions%2F-435046686) | [androidJvm]<br>open fun [initCause](../-storage-exception/index.md#-418225042%2FFunctions%2F-435046686)(p0: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)): [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html) |
| [printStackTrace](../-storage-exception/index.md#-1769529168%2FFunctions%2F-435046686) | [androidJvm]<br>open fun [printStackTrace](../-storage-exception/index.md#-1769529168%2FFunctions%2F-435046686)()<br>open fun [printStackTrace](../-storage-exception/index.md#1841853697%2FFunctions%2F-435046686)(p0: [PrintStream](https://developer.android.com/reference/kotlin/java/io/PrintStream.html))<br>open fun [printStackTrace](../-storage-exception/index.md#1175535278%2FFunctions%2F-435046686)(p0: [PrintWriter](https://developer.android.com/reference/kotlin/java/io/PrintWriter.html)) |
| [setStackTrace](../-storage-exception/index.md#2135801318%2FFunctions%2F-435046686) | [androidJvm]<br>open fun [setStackTrace](../-storage-exception/index.md#2135801318%2FFunctions%2F-435046686)(p0: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[StackTraceElement](https://developer.android.com/reference/kotlin/java/lang/StackTraceElement.html)&gt;) |
