import SwiftUI

struct ExperienceView: View {
    var body: some View {
        NavigationStack {
            ScrollView {
                VStack(alignment: .leading, spacing: 16) {
                    Eyebrow(text: "Experience & Trust")
                    Text(Company.experienceTitle)
                        .font(.title3.weight(.bold))
                        .foregroundStyle(Brand.ink)
                        .fixedSize(horizontal: false, vertical: true)
                    ForEach(Company.experience, id: \.self) { paragraph in
                        Text(paragraph)
                            .font(.body)
                            .foregroundStyle(Brand.muted)
                            .fixedSize(horizontal: false, vertical: true)
                    }
                    VStack(spacing: 12) {
                        ForEach(Company.partnerships) { item in
                            BrandCard {
                                HStack(spacing: 14) {
                                    MarkIcon(systemImage: item.symbol)
                                    Text(item.name)
                                        .font(.body.weight(.semibold))
                                        .foregroundStyle(Brand.ink)
                                        .fixedSize(horizontal: false, vertical: true)
                                    Spacer(minLength: 0)
                                }
                            }
                        }
                    }
                }
                .padding(.horizontal, 20)
                .padding(.vertical, 16)
            }
            .screenBackground()
            .navigationTitle("Experience")
            .navigationBarTitleDisplayMode(.large)
        }
    }
}
