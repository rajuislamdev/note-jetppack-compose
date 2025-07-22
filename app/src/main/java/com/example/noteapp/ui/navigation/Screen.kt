import com.example.noteapp.model.Note

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object AddEditNote : Screen("add_edit_note?noteId={noteId}") {
        fun note(note: Note?) = "add_edit_note?note=$note"
    }
}