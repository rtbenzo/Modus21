import SwiftUI

@main
struct Modus21App: App {
    @State private var router = AppRouter()

    var body: some Scene {
        WindowGroup {
            RootView()
                .environment(router)
        }
    }
}

struct RootView: View {
    @Environment(AppRouter.self) private var router

    var body: some View {
        @Bindable var router = router
        TabView(selection: $router.tab) {
            MissionView()
                .tabItem { Label("Mission", systemImage: "flag") }
                .tag(AppTab.mission)
            CapabilitiesView()
                .tabItem { Label("Capabilities", systemImage: "square.grid.2x2") }
                .tag(AppTab.capabilities)
            ExperienceView()
                .tabItem { Label("Experience", systemImage: "checkmark.seal") }
                .tag(AppTab.experience)
            CareersView()
                .tabItem { Label("Careers", systemImage: "person.2") }
                .tag(AppTab.careers)
            ContactView()
                .tabItem { Label("Contact", systemImage: "phone") }
                .tag(AppTab.contact)
        }
        .tint(Brand.navy)
    }
}
