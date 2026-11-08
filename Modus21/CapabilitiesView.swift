import SwiftUI

struct CapabilitiesView: View {
    var body: some View {
        NavigationStack {
            ScrollView {
                VStack(alignment: .leading, spacing: 16) {
                    Eyebrow(text: "Capabilities")
                    Text("Specialized Expertise for Complex Missions")
                        .font(.title3.weight(.bold))
                        .foregroundStyle(Brand.ink)
                        .fixedSize(horizontal: false, vertical: true)
                    Text(Company.capabilitiesIntro)
                        .font(.body)
                        .foregroundStyle(Brand.muted)
                        .fixedSize(horizontal: false, vertical: true)
                    VStack(spacing: 12) {
                        ForEach(Company.capabilities) { capability in
                            NavigationLink(value: capability) {
                                BrandCard {
                                    HStack(alignment: .top, spacing: 14) {
                                        MarkIcon(systemImage: capability.symbol)
                                        VStack(alignment: .leading, spacing: 4) {
                                            Text(capability.name)
                                                .font(.headline)
                                                .foregroundStyle(Brand.ink)
                                                .multilineTextAlignment(.leading)
                                            Text(capability.summary)
                                                .font(.subheadline)
                                                .foregroundStyle(Brand.muted)
                                                .multilineTextAlignment(.leading)
                                        }
                                        Spacer(minLength: 0)
                                        Image(systemName: "chevron.right")
                                            .font(.footnote.weight(.semibold))
                                            .foregroundStyle(Brand.muted)
                                            .padding(.top, 4)
                                            .accessibilityHidden(true)
                                    }
                                }
                            }
                            .buttonStyle(.plain)
                        }
                    }
                }
                .padding(.horizontal, 20)
                .padding(.vertical, 16)
            }
            .screenBackground()
            .navigationTitle("Capabilities")
            .navigationBarTitleDisplayMode(.large)
            .navigationDestination(for: Capability.self) { capability in
                CapabilityDetailView(capability: capability)
            }
        }
    }
}

struct CapabilityDetailView: View {
    let capability: Capability

    var body: some View {
        ScrollView {
            VStack(alignment: .leading, spacing: 18) {
                MarkIcon(systemImage: capability.symbol, size: 52)
                Text(capability.name)
                    .font(.title2.weight(.bold))
                    .foregroundStyle(Brand.ink)
                    .fixedSize(horizontal: false, vertical: true)
                Text(capability.summary)
                    .font(.body)
                    .foregroundStyle(Brand.muted)
                    .fixedSize(horizontal: false, vertical: true)
                Text(Company.capabilitiesIntro)
                    .font(.body)
                    .foregroundStyle(Brand.ink)
                    .fixedSize(horizontal: false, vertical: true)
                Link(destination: Company.linkedIn) {
                    FilledAction(title: "Discuss on LinkedIn")
                }
                .padding(.top, 8)
                Text(Company.linkedInNote)
                    .font(.footnote)
                    .foregroundStyle(Brand.muted)
                    .fixedSize(horizontal: false, vertical: true)
            }
            .padding(20)
        }
        .screenBackground()
        .navigationTitle(capability.name)
        .navigationBarTitleDisplayMode(.inline)
    }
}
