import SwiftUI

struct MissionView: View {
    @Environment(AppRouter.self) private var router

    var body: some View {
        NavigationStack {
            ScrollView {
                VStack(alignment: .leading, spacing: 22) {
                    hero
                    about
                    facts
                    values
                    footer
                }
                .padding(.horizontal, 20)
                .padding(.vertical, 16)
            }
            .screenBackground()
            .navigationTitle("Mission")
            .navigationBarTitleDisplayMode(.large)
        }
    }

    private var hero: some View {
        BrandCard {
            VStack(alignment: .leading, spacing: 16) {
                Eyebrow(text: Company.region)
                Image("Wordmark")
                    .resizable()
                    .scaledToFit()
                    .frame(maxWidth: 240, alignment: .leading)
                    .accessibilityLabel("Modus21")
                Text(Company.tagline)
                    .font(.title2.weight(.bold))
                    .foregroundStyle(Brand.ink)
                    .fixedSize(horizontal: false, vertical: true)
                Text(Company.hero)
                    .font(.body)
                    .foregroundStyle(Brand.muted)
                    .fixedSize(horizontal: false, vertical: true)
                VStack(spacing: 10) {
                    Button {
                        router.tab = .capabilities
                    } label: {
                        FilledAction(title: "Learn About Our Capabilities")
                    }
                    .buttonStyle(.plain)
                    Button {
                        router.tab = .contact
                    } label: {
                        OutlineAction(title: "Contact Us")
                    }
                    .buttonStyle(.plain)
                }
                .padding(.top, 4)
            }
        }
    }

    private var about: some View {
        VStack(alignment: .leading, spacing: 12) {
            Eyebrow(text: "About Us")
            Text(Company.aboutTitle)
                .font(.title3.weight(.bold))
                .foregroundStyle(Brand.ink)
                .fixedSize(horizontal: false, vertical: true)
            ForEach(Company.about, id: \.self) { paragraph in
                Text(paragraph)
                    .font(.body)
                    .foregroundStyle(Brand.muted)
                    .fixedSize(horizontal: false, vertical: true)
            }
        }
    }

    private var facts: some View {
        LazyVGrid(columns: [GridItem(.flexible(), spacing: 12), GridItem(.flexible(), spacing: 12)], spacing: 12) {
            ForEach(Company.facts, id: \.label) { fact in
                BrandCard {
                    VStack(alignment: .leading, spacing: 6) {
                        Text(fact.label.uppercased())
                            .font(.caption2.weight(.semibold))
                            .tracking(0.6)
                            .foregroundStyle(Brand.navy)
                        Text(fact.value)
                            .font(.subheadline.weight(.semibold))
                            .foregroundStyle(Brand.ink)
                            .fixedSize(horizontal: false, vertical: true)
                    }
                }
            }
        }
    }

    private var values: some View {
        VStack(alignment: .leading, spacing: 12) {
            Eyebrow(text: "Corporate Values")
            Text("Integrity, Quality, and Value")
                .font(.title3.weight(.bold))
                .foregroundStyle(Brand.ink)
            Text(Company.valuesIntro)
                .font(.body)
                .foregroundStyle(Brand.muted)
                .fixedSize(horizontal: false, vertical: true)
            ForEach(Company.values) { value in
                BrandCard {
                    VStack(alignment: .leading, spacing: 6) {
                        Text(value.name)
                            .font(.headline)
                            .foregroundStyle(Brand.navy)
                        Text(value.detail)
                            .font(.body)
                            .foregroundStyle(Brand.muted)
                            .fixedSize(horizontal: false, vertical: true)
                    }
                }
            }
        }
    }

    private var footer: some View {
        Text("© 2026 \(Company.name). All rights reserved.\nSmall Business · Founded 2004")
            .font(.footnote)
            .foregroundStyle(Brand.muted)
            .frame(maxWidth: .infinity, alignment: .leading)
            .padding(.top, 4)
    }
}
