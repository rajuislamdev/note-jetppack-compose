import com.example.noteapp.ui.navigation.Routes

sealed class Screen(val route: String) {
    object Splash : Screen(Routes.SPLASH)
    object Home : Screen(Routes.HOME)
    object AddEditNote : Screen("${Routes.ADD_EDIT_NOTE}?noteId={noteId}") {
        fun createRoute(noteId: Int?): String {
            return if (noteId != null) {
                "${Routes.ADD_EDIT_NOTE}?noteId=$noteId"
            } else {
                Routes.ADD_EDIT_NOTE
            }
        }
    }
}