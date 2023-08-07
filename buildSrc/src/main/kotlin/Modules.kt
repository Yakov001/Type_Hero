sealed class Modules(
    val nameSpace : String,
    val path : String
) {
    object App : Modules(
        nameSpace = "${Android.nameSpace}.app",
        path =":app"
    )
    object Data : Modules(
        nameSpace = "${Android.nameSpace}.data",
        path =":data"
    )
    object Domain : Modules(
        nameSpace = "${Android.nameSpace}.domain",
        path =":domain"
    )
    object Presentation : Modules(
        nameSpace = "${Android.nameSpace}.presentation",
        path =":presentation"
    )
}