sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object AddEditNote : Screen("add_edit_note?noteId={noteId}") {
        fun passNoteId(noteId: Int?) = "add_edit_note?noteId=$noteId"
    }
}